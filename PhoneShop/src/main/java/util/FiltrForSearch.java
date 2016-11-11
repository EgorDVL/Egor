package util;

import bean.Characteristic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Egor on 12.11.2016.
 */
public class FiltrForSearch {
    public static Set<Double> getUniqueMainCamera(List<Characteristic> characteristics) {
        return characteristics.stream().map(Characteristic::getMainCamera).collect(Collectors.toSet());
    }

    public static Set<Double> getUniqueScreenSize(List<Characteristic> characteristics) {
        return characteristics.stream().map(Characteristic::getScreenSize).collect(Collectors.toSet());
    }


    public static Set<Integer> getUniqueMemory(List<Characteristic> characteristics) {
        return characteristics.stream().map(Characteristic::getMemory).collect(Collectors.toSet());
    }

    public static Set<String> getUniqueColor(List<Characteristic> characteristics) {
        Set<String> set = new HashSet<>();
        for (Characteristic c : characteristics) {
            if (c.getColor() != null) {
                set.add(c.getColor());
            }
        }
        return set;
//        return characteristics.stream().map(Characteristic::getColor).collect(Collectors.toSet());
    }

    public static Set<Double> getUniqueRam(List<Characteristic> characteristics) {
        return characteristics.stream().map(Characteristic::getRam).collect(Collectors.toSet());
    }
}
