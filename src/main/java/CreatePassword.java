import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreatePassword {
    private final static Map<String, List<String>> PASSWORD_OPTIONS = new HashMap<String, List<String>>();


    public CreatePassword() {
        PASSWORD_OPTIONS.put("Symbols", new ArrayList<>(Arrays.asList("@","#","$","%")));
        PASSWORD_OPTIONS.put("Numbers", new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","0")));
        PASSWORD_OPTIONS.put("Lowercase", new ArrayList<>(IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.toList())));
        PASSWORD_OPTIONS.put("Uppercase", new ArrayList<>(IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.toList())));
        PASSWORD_OPTIONS.put("NoAmb", new ArrayList<>(Arrays.asList("{", "}", "[", "]", "(", ")", "/", "\\", "'", "`", "~", "," )));
    }

     List<String> createSignListToCreatePassword(List<String> parameterNames){
        List<String> passwordSigns = new ArrayList<>();
        for (String name : parameterNames){
            if(PASSWORD_OPTIONS.containsKey(name)) {
                passwordSigns.addAll(PASSWORD_OPTIONS.get(name));
            }
        }
        return passwordSigns;
    }

     String createPassword(List<String> passwordSigns, Integer passwordLength){
        StringBuilder passworsBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++){
            passworsBuilder.append(passwordSigns.get(random.nextInt(passwordSigns.size())));
        }
        return passworsBuilder.toString();
    }
}
