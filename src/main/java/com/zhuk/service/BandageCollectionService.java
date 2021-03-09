package com.zhuk.service;

import com.zhuk.domain.aidkit.Bandage;
import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.aidkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BandageCollectionService {

    public List<String> getMostFrequentBandageMaterials(List<FirstAidKit> firstAidKitList) {
        List<String> result = new ArrayList<>();
        firstAidKitList.stream()
                .flatMap(x -> x.getBandages().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Bandage::isSterile))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getMaterial().getMaterial(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

    public int getClothLengthSum(List<Bandage> list) {
        return list.stream().
                filter(x -> x.getMaterial().equals(Material.CLOTH)).
                mapToInt(Bandage::getLength).
                sum();
    }

    public double getAverageLength(List<Bandage> list) {
        return list.stream().
                mapToInt(Bandage::getLength).
                average().getAsDouble();
    }

    public int getMaxLength(List<Bandage> list) {
        return list.stream().
                mapToInt(Bandage::getLength).
                max().getAsInt();
    }

    public Map<Boolean, List<Bandage>> getGroupByMaterialAndLength(Function<Bandage, Boolean> bandagingMaterialBooleanFunction, FirstAidKit firstAidKit) {
        return firstAidKit.getBandages().stream().
                collect(Collectors.groupingBy(bandagingMaterialBooleanFunction));
    }
}
