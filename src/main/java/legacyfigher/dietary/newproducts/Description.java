package legacyfigher.dietary.newproducts;

public class Description {
    // not descriptive variable
    private String description;
    String longDescription;

    public Description(String description, String longDescription) {
        this.description = description;
        this.longDescription = longDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    void replaceCharFromDescription(String charToReplace, String replaceWith) {
        if (isEmptyDescription()) {
            throw new IllegalStateException("null or empty desc");
        }

        longDescription = longDescription.replace(charToReplace, replaceWith);
        description = description.replace(charToReplace, replaceWith);
    }

    private boolean isEmptyDescription() {
        return longDescription == null || longDescription.isEmpty()
                || description == null || description.isEmpty();
    }

    String formatDescription() {
        if (isEmptyDescription()) {
            return "";
        }
        return description + " *** " + longDescription;
    }
}
