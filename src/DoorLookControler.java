import java.util.ArrayList;
import java.util.List;

public class DoorLookControler {
    private List<Chirias> tenants = new ArrayList<>();

    public void addTenant(Chirias tenant) throws TenantAlreadyExistsException {
        // Verificăm dacă chiriașul există deja
        for (Chirias existingTenant : tenants) {
            if (existingTenant.getName().equals(tenant.getName())) {
                throw new TenantAlreadyExistsException("Chiriașul '" + tenant.getName() + "' există deja.");
            }
        }
        tenants.add(tenant);
    }

    public Chirias findTenant(String name) throws TenantNotFoundException {
        for (Chirias tenant : tenants) {
            if (tenant.getName().equals(name)) {
                return tenant; // Returnează chiriașul găsit
            }
        }
        throw new TenantNotFoundException("Chiriașul cu numele '" + name + "' nu a fost găsit."); // Aruncă excepția
    }

    public void listTenants() {
        System.out.println("Lista chiriașilor:");
        for (Chirias tenant : tenants) {
            System.out.println(tenant.getName());
        }
    }
}
