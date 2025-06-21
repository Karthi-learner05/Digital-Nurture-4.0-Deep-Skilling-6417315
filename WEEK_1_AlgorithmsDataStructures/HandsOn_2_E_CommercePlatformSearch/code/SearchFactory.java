package WEEK_1_AlgorithmsDataStructures.HandsOn_2_E_CommercePlatformSearch.code;

public class SearchFactory {
    public static Search getSearch(String type) {
        switch (type.toLowerCase()) {
            case "linear":
                return new LinearSearch();
            case "binary":
                return new BinarySearch();
            default:
                throw new IllegalArgumentException("Error: Search Method will be added soon " + type);
        }
    }
}
