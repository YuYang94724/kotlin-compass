package c20;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class Jhava {

    private int hitPoints = 52489112;
    private String greeting = "BLARGH";
    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    @Nullable
    public String determineFriendshipLevel(){
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
        List<String> spells = spellbook.spells;
        for (String spell : spells) {
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);
        Spellbook.getSpellbookGreeting();

        Function1<String, Unit> translator = Hero.getTranslator();
        translator.invoke("TRUCE");
    }

    public void offerFood(){
        Hero.handOverFood("Pizza");
    }
    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Caught!");
        } }

}
