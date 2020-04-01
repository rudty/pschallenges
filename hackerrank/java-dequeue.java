        int[] arr = new int[n];
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            if (i >= m) {
                int decreaseKey = arr[i - m];
                int v = countMap.get(decreaseKey);
                v -= 1;
                if (v == 0) {
                    countMap.remove(decreaseKey);
                } else {
                    countMap.put(decreaseKey, v);
                }
            }
            maxCount = Math.max(countMap.size(), maxCount);
        }


        System.out.println(maxCount);