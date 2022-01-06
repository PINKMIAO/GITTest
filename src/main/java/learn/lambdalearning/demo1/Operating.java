package learn.lambdalearning.demo1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

/**
 * @author Baven
 * @date 2022/1/5 14:07
 */
public class Operating {
    private List<String> beforeJava7(List<Dish> dishList) {
        List<Dish> lowCaloricDishes = new ArrayList<>();

        // 1.筛选出卡路里小于400的菜肴
        for (Dish dish : dishList) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        // 2.对筛选出的菜肴进行排序
        // lambda 变形过程
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
             @Override
             public int compare(Dish o1, Dish o2) {
                   return Integer.compare(o1.getCalories(), o2.getCalories());
             }
        });
        // |
        // lowCaloricDishes.sort(new Comparator<Dish>() {
        //      @Override
        //      public int compare(Dish o1, Dish o2) {
        //           return Integer.compare(o1.getCalories(), o2.getCalories());
        //      }
        // });
        // |
        // lowCaloricDishes.sort((o1, o2) -> Integer.compare(o1.getCalories(), o2.getCalories()));
        // |
        // lowCaloricDishes.sort(Comparator.comparingInt(Dish::getCalories));

        // 3.获取排序后菜肴的名字
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;
    }

    /**
     * 前后对比
     * @param dishList 数据
     * @return 操作完的数据
     */
    private List<String> afterJava8(List<Dish> dishList) {
        return dishList.stream()
                //筛选出卡路里小于400的菜肴
                .filter(d -> d.getCalories() < 400)
                //根据卡路里进行排序
                .sorted(comparing(Dish::getCalories))
                //提取菜肴名称
                .map(Dish::getName)
                //转换为List
                .collect(Collectors.toList());
    }

    // 新需求, 对数据库查询到的菜肴根据菜肴种类进行分类，返回一个Map<Type, List<Dish>>的结果
    private static Map<String, List<Dish>> beforeJdk8(List<Dish> dishList) {
        Map<String, List<Dish>> result = new HashMap<>();

        for (Dish dish : dishList) {
            //不存在则初始化
            if (result.get(dish.getType())==null) {
                List<Dish> dishes = new ArrayList<>();
                dishes.add(dish);
                result.put(dish.getType(), dishes);
            } else {
                //存在则追加
                result.get(dish.getType()).add(dish);
            }
        }

        return result;
    }

    private static Map<String, List<Dish>> afterJdk8(List<Dish> dishList) {
        return dishList.stream().collect(groupingBy(Dish::getType));

        // // 另外总和功能 通过summarizingInt同时求总和、平均值、最大值、最小值
        // IntSummaryStatistics intSummaryStatistics = dishList.stream().collect(summarizingInt(Dish::getCalories));
        // // 获取平均值
        // double average = intSummaryStatistics.getAverage();
        // // 获取最小值
        // int min = intSummaryStatistics.getMin();
        // // 获取最大值
        // int max = intSummaryStatistics.getMax();
        // // 获取总和
        // long sum = intSummaryStatistics.getSum();
    }
}
