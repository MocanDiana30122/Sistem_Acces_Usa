public class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false; // Ușa este închisă la început
    }

    public void openDoor(Chirias tenant) {
        // Deschide ușa dacă chiriașul există
        if (tenant != null) {
            isOpen = true;
            System.out.println("Usa este deschisa pentru chiriasul: " + tenant.getName());
        } else {
            System.out.println("Chiriasul nu exista. Usa nu poate fi deschisa");
        }
    }

    public void closeDoor() {
        isOpen = false;
        System.out.println("Ușa este închisă.");
    }

    public boolean isOpen() {
        return isOpen;
    }
}
