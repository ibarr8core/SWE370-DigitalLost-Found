package model;

public class Item {
    private String name;
    private String description;
    private String location;
    private boolean claimed = false;
    private String claimStatus = "Unclaimed";   // NEW

    public Item(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public boolean isClaimed() { return claimed; }

    public void setClaimed(boolean claimed) { this.claimed = claimed; }

    public String getClaimStatus() { return claimStatus; }        // NEW
    public void setClaimStatus(String claimStatus) { this.claimStatus = claimStatus; }   // NEW

    @Override
    public String toString() {
        return String.format("%s - %s (%s) [%s]",
                name, description, location, claimStatus);
    }
}
