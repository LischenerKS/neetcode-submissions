class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, Integer> groupIdByAnagramsIdentifiers= new HashMap<>();
        List<List<String>> wordsInAnagramGroups = new ArrayList<>();

        for (String s : strs) {
            Map<Character, Integer> identifier = new HashMap<>();
            for (Character c : s.toCharArray()) {
                Integer counter = identifier.get(c);
                if (counter == null) {
                    identifier.put(c, 1);
                }
                else {
                    identifier.put(c, counter + 1);
                }
            }


            boolean isGroupExists = false; 
            for (Map<Character, Integer> existsIdent : groupIdByAnagramsIdentifiers.keySet()) {
                if (identifier.equals(existsIdent)) {
                    Integer groupIndex =  groupIdByAnagramsIdentifiers.get(existsIdent);
                    wordsInAnagramGroups.get(groupIndex).add(s);
                    isGroupExists = true;
                }
            }

            if (!isGroupExists) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                wordsInAnagramGroups.add(newGroup);
                Integer newGroupIndex = wordsInAnagramGroups.size() - 1;
                groupIdByAnagramsIdentifiers.put(identifier, newGroupIndex);
            }
            
        }
        return wordsInAnagramGroups;
    }

    
}
