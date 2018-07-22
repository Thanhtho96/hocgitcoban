/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nghiemmanh
 */
public class CollectionsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ArrayList<Integer> lists = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            lists.add(random.nextInt(1000));
//        }
//        lists.sort(Comparator.naturalOrder());
//        int j = 0;
//        for (Integer x : lists) {
//            System.out.println("x" + j + " = " + x);
//            j++;
//        }
//
//        while (true) {
//            System.out.println("Nhap vao key: ");
//            int key = new Scanner(System.in).nextInt();
//            if (key < 0) {
//                break;
//            }
//            int index = Collections.binarySearch(lists, key);
//            System.out.println("Index = " + index);
//
//        }
//
//        // create arraylist
//        ArrayList<String> arlst = new ArrayList<String>();
//
//        // populate the list
//        arlst.add("TP");
//        arlst.add("PROVIDES");
//        arlst.add("QUALITY");
//        arlst.add("TUTORIALS");
//
//        // search the list for key 'QUALITY'
//        int index = Collections.binarySearch(arlst, "QUALITY");
//
//        System.out.println("'QUALITY' is available at index: " + index);

//        List<Student> students = new ArrayList<>();
        Student s1 = new Student(10, "Ha");
        Student s2 = new Student(8, "Thanh");
        Student s3 = new Student(12, "Trang");
//        students.add(s1);
//        students.add(s3);
//        students.add(s2);
//        Collections.sort(students);
//        for (Student student : students) {
//            System.out.println("Student: " + student.getName());
//        }

        Map<String, Student> mapStudent = new HashMap<>();
        mapStudent.put("s1", s1);
        mapStudent.put("s2", s2);
        mapStudent.put("s3", s3);

        Set<String> keys = mapStudent.keySet();
        for (String key : keys) {
            System.out.println("Name: " + mapStudent.get(key).getName());
        }
        for (Map.Entry<String, Student> entry : mapStudent.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + ":" + value.getMark());
        }
    }

}
