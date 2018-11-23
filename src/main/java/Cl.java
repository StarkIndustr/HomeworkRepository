import com.lexicalscope.jewel.cli.Option;

public interface Cl {
    @Option(shortName = "l" , longName =  "locale" , description = "Locale(Default en_Us) , defaultValue = \"en_US\"")
    String getLocale();

    @Option( shortName="r" , longName  = "reverse" , description = "Reverse the result of comparisons",defaultValue = "false")
    String isReverse();


    @Option( shortName="i" , longName = "ignore_case" , description = "Fold lower case to upper case characters using supplied locale",defaultValue = "false" )
    String isIgnore();


    @Option(  shortName="o" , longName = "output" , description = "Write result to File instead of standard output.",defaultToNull = true)
    String getOutput();


    @Option(shortName = "f" , longName = "input" , description = "Input file that contains lines to be sorted")
    String getInput();

}
