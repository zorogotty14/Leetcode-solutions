class Solution {
    class Person {
    String name;
    int height;
    
    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        
        Arrays.sort(people, (a, b) -> b.height - a.height);
        
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }
        
        return sortedNames;
    }
}