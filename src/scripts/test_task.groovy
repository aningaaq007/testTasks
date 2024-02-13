println "result groovy: " +
        [1, 3, 4, 5, 1, 5, 4].groupBy().collectEntries { k, v -> [(k): v.size()] }