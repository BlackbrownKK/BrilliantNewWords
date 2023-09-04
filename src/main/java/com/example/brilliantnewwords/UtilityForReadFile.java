package com.example.brilliantnewwords;

import java.io.*;
import java.util.*;


public class UtilityForReadFile {

    String patch = "C:\\Users\\k.kosteniuk\\Desktop\\hillel\\" +
            "BrilliantNewWords\\src\\main\\resources\\write one’s ideas down.txt";
    File f1 = new File(patch);


    public Map<String, String> startTiTest() {
        Map<String, String> vocabularyPaar;
        Map<String, String> result;
        try {
            vocabularyPaar = makeVocabularyPaar(readVocabulary(f1));
            result = getRandomHashMapElements(vocabularyPaar, 4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public   Map<String, String> getRandomHashMapElements(Map<String, String> inputMap, int count) {
        List<String> keys = new ArrayList<>(inputMap.keySet());
        List<String> values = new ArrayList<>(inputMap.values());
        Map<String, String> randomPairs = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(keys.size());
            String randomKey = keys.get(randomIndex);
            String randomValue = values.get(randomIndex);
            randomPairs.put(randomKey, randomValue);
        }

        return randomPairs;
    }


    private Map<String, String> makeVocabularyPaar(ArrayList<String> baseVocWords) {
        Map<String, String> vocabularyPaar = new HashMap<>() ;
        int lengthBaseVocWords = baseVocWords.size();

        for (int i = 0; i < lengthBaseVocWords-1; i+=2) {//*******#
            vocabularyPaar.put(baseVocWords.get(i), baseVocWords.get(i + 1));
        }
        return vocabularyPaar;
    }

    public ArrayList<String> readVocabulary(File file) throws IOException {
        ArrayList<String> vocabularyBase = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals(""))vocabularyBase.add(line);
            }
        }

        return vocabularyBase;
    }


}

