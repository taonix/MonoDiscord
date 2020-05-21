package bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class App {
    private static DiscordApi api;
    private static final String token = "NzExMjcyMDIyMTM0NDg5MTQ4.XsA0LA.OybHdj0tfnaNjL3rItj5mSby14U";

    public static void main(String[] args) {
        api = new DiscordApiBuilder().setToken(token).login().join();
        System.out.println("Logged-in !");
        System.out.println(api.createBotInvite());

        api.addMessageCreateListener(event -> {

            Message msg = event.getMessage();

            String msgContent = msg.getContent();
            TextChannel msgChannel = event.getChannel();
            MessageAuthor msgAuthor = msg.getAuthor();


            
            switch (msgContent) {

                case ">off":
                    if (msgAuthor.getIdAsString().equals("497414712536072195") || msgAuthor.getIdAsString().equals("330775548114632704")) {
                        msgChannel.sendMessage(msgAuthor.getDiscriminatedName() + " m'a éteint");
                        System.out.println("logged-out !");
                        api.disconnect();
                        System.exit(0);
                    }
                    break;

                case ">join":


                    }

        });
    }

    public void join() {
        ArrayList<Server> servers = new ArrayList<>(api.getServers());

        for (int i = 0; i < servers.size(); i++) {
            ArrayList<User> usr = new ArrayList<>(servers.get(i).getMembers());

            for (int o = 0; o < usr.size(); o++) {
                ArrayList<Role> roles = new ArrayList<>(usr.get(o).getRoles(servers.get(i)));

            }
            return;
        }
    }
}
