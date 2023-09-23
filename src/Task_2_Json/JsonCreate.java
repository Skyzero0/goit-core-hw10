package Task_2_Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCreate {
    public void jsonFromTxt(String fileName) throws IOException {
//    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String s = br.readLine();
        String[] title = s.split(" ");

        ArrayList<User> users = new ArrayList<>();
        User us;
        while ((us = createUsers(br)) != null) {
            users.add(us);
        }
        br.close();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (User st : users) {
            String json = gson.toJson(st);
            System.out.println(json);
        }
        createJsonFile(gson, users);
    }

    private User createUsers(BufferedReader br) throws IOException {

        String g = br.readLine();
        User u = new User();
        if (g != null) {
            String[] Objects = g.split(" ");
            u.setName(Objects[0]);
            u.setAge(Integer.parseInt(Objects[1]));
            return u;
        }
        return null;
    }

    private void createJsonFile(Gson g, ArrayList<User> us) {

        try (FileWriter fr = new FileWriter("user.json");) {
            ArrayList<String> arrJs = new ArrayList<>();
            for (User u : us) {
                arrJs.add(g.toJson(u));
            }
            fr.write(String.valueOf(arrJs));
            fr.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User> readJson(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        Gson gson = new Gson();

        ArrayList<User> ul = gson.fromJson(bufferedReader, new TypeToken<List<User>>() {}.getType());
//        for (User rq : ul) {
//            System.out.println(rq.getName() + " " + rq.getAge());
//        }
        bufferedReader.close();
        return ul;
    }
}
