import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // 1. Сортировка списков слиянием
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(2);
        System.out.println("Before sorting: " + list);
        mergeSort(list);
        System.out.println("After sorting: " + list);

        // 2. Удаление чётных чисел из списка
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("List without even numbers: " + numbers);

        // 3. Минимальное, максимальное и среднее из списка
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(5);
        nums.add(2);
        nums.add(7);
        int min = nums.get(0);
        int max = nums.get(0);
        int sum = 0;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
            sum += i;
        }
        double avg = (double) sum / nums.size();
        System.out.println("Min: " + min + ", Max: " + max + ", Avg: " + avg);

        // 4. Объединение двух списков без повторений
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.removeAll(list1);
        list1.addAll(list2);
        System.out.println("Merged list without duplicates: " + list1);

        // 5. Создание ArrayList и добавление 10000 нулей в начало списка
        ArrayList<Integer> zerosList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            zerosList.add(0, 0);
        }
        System.out.println("List of 10000 zeros: " + zerosList);

        // 6. Создание LinkedList и добавление 10000 нулей в начало списка
        LinkedList<Integer> zerosLinkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            zerosLinkedList.addFirst(0);
        }
        System.out.println("Linked list of 10000 zeros: " + zerosLinkedList);

        // 7. Сравнение времени работы ArrayList и LinkedList
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            zerosList.add(0, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            zerosLinkedList.addFirst(0);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList time: " + (end - start) + " ms");
    }

    // Реализация сортировки списков слиянием
    private static void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }
        int middle = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle, list.size()));
        mergeSort(left);
        mergeSort(right);
        merge(left, right, list);
    }

    private static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> result) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.set(resultIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                result.set(resultIndex, right.get(rightIndex));
                rightIndex++;
            }
            resultIndex++;
        }
        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
        for (int i = restIndex; i < rest.size(); i++) {
            result.set(resultIndex, rest.get(i));
            resultIndex++;
        }
    }
}