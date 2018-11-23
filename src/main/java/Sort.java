import com.lexicalscope.jewel.cli.CliFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
public class Sort {
    public static void sort(Cl opt) throws IOException,NullPointerException {
        System.out.println("opt.getOutput():"+opt.getOutput());
        System.out.println("opt.getInput():"+opt.getInput());
        System.out.println("opt.isIgnore():"+opt.isIgnore());
        System.out.println("opt.isReverse():"+opt.isReverse());
        System.out.println("opt.getLocale():"+opt.getLocale());

        File input=new File(opt.getInput());
        Path path=Paths.get(input.getAbsolutePath());
        List<String> linenumber=Files.readAllLines(path,StandardCharsets.UTF_8);
        linenumber.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ("true".equalsIgnoreCase(opt.isReverse())) {
                    if ("true".equalsIgnoreCase(opt.isIgnore())) {
                        return o2.compareToIgnoreCase(o1);
                    } else {
                        return o2.compareTo(o1);
                    }
                } else {
                    if ("true".equalsIgnoreCase(opt.isIgnore())) {
                        return o1.compareToIgnoreCase(o2);
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        if (opt.getOutput()==null){
            System.out.println("Sorting Later :");
            for (String numerator:linenumber){
                System.out.println(numerator);
            }
        }
        else{
            File output=new File(opt.getOutput());
            Files.write(Paths.get(output.getAbsolutePath()),linenumber,StandardCharsets.UTF_8);
            System.out.println("sort result : " + output.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException,NullPointerException{
        Cl opt=CliFactory.parseArguments(Cl.class,args);
        Sort.sort(opt);

    }

}
