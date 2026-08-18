package ewu.event.system;

public class EWU_Event_System {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            new LoginForm().setVisible(true);

        });
    }
}
