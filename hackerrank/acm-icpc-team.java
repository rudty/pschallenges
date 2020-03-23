    static int[] acmTeam(String[] topic) {
        TreeMap<Integer, Integer> groupBy = new TreeMap<>();
        for (int person_1_i = 0; person_1_i < topic.length; ++person_1_i) {
            for (int person_2_i = person_1_i + 1; person_2_i < topic.length; ++person_2_i) {
                int c = 0;
                for (int topic_i = 0; topic_i < topic[person_1_i].length(); ++topic_i) {
                    if (topic[person_1_i].charAt(topic_i) == '1' ||
                            topic[person_2_i].charAt(topic_i) == '1') {
                        c += 1;
                    }
                }
                groupBy.put(c, groupBy.getOrDefault(c, 0) + 1);
            }
        }
        Map.Entry<Integer, Integer> last = groupBy.lastEntry();
        return new int[]{last.getKey(), last.getValue()};
    }
