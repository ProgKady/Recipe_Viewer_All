package kadysoft.kady;

public class KeyDecoder {
    
    public static String extractData(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key is empty");
        }

        String trimmed = key.trim();
        String[] parts = trimmed.split("-");

        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid key format! Expected 7 blocks (e.g. ABCDE-FGHIJ-...) but got " + parts.length);
        }

        try {
            // طباعة للتصحيح (مهمة)
            System.out.println("Original Key: " + trimmed);
            System.out.println("Parts: " + String.join(" | ", parts));

            String extracted = "" +
                parts[0].charAt(4) +
                parts[1].charAt(0) +
                parts[2].charAt(2) +
                parts[3].charAt(1) +
                parts[4].charAt(3) +
                parts[5].charAt(2) +
                parts[6].charAt(3);

            System.out.println("Extracted Password (7 chars): " + extracted);
            
            return extracted;

        } catch (Exception e) {
            throw new IllegalArgumentException("Key structure error: " + e.getMessage());
        }
    }
}