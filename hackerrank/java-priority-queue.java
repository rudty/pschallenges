class Student implements Comparable<Student>{
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student) {
        if (cgpa > student.cgpa) {
            return 1;
        } else if (cgpa < student.cgpa) {
            return -1;
        }
        int nameCompare = name.compareTo(student.name);
        if (nameCompare < 0) {
            return 1;
        } else if (nameCompare > 0) {
            return -1;
        }

        return id - student.id;
    }
}
class Priorities {
    List<Student> getStudents(List<String> events) {
        java.util.PriorityQueue<Student> q = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        for (String event : events) {
            String[] input = event.split(" ");
            String cmd = input[0];
            if ("ENTER".equals(cmd)) {
                String name = input[1];
                double cgpa = Double.parseDouble(input[2]);
                int id = Integer.parseInt(input[3]);
                q.add(new Student(id, name, cgpa));
            } else if ("SERVED".equals(cmd)) {
                q.poll();
            }
        }

        ArrayList<Student> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            ret.add(q.poll());
        }

        return ret;
    }
}
