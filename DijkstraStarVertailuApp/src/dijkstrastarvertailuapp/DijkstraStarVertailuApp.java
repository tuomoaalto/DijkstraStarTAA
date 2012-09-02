/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author aaltotuo
 */
public class DijkstraStarVertailuApp
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int     mode=0;      //mode 1 = gridi tiedostosta, mode 2 = batch
        String  fileName    = null;
        String  usedAlgos   = null;
        String  usedHeurs   = null;
        int     timesToLoop = 1;
        boolean printGrids  = false;

        for (int i = 0; i < args.length; i++) 
        {
            System.out.println("Arg[" + i + "]: " + args[i]);
        }
        
        if (args.length == 0 || args.length > 6 )
        {
            System.out.println("puae1");
            printUsageAndExit();
        }
                
        if (args[0].matches("-f"))
        {
            mode = 1;
            fileName  = args[1];
            try
            {
                usedAlgos = args[3];
                if (!usedAlgos.matches("M") && !usedAlgos.matches("A") && !usedAlgos.matches("D"))
                {
                    System.out.println("puae2");
                    printUsageAndExit();
                }
            }
            catch (Exception e)
            {
                usedAlgos = "M";
            }

            try
            {
                usedHeurs = args[5];
                if (!usedHeurs.matches("E") && !usedHeurs.matches("M"))
                {
                    usedHeurs = "E";
                }
                
            }
            catch (Exception e)
            {
                usedHeurs = "E";
            }
            
            printGrids = true;
        }
        else if (args[0].matches("-t"))
        {
            mode = 2;
            try
            {
                timesToLoop = Integer.parseInt(args[1]);
            }
            catch (Exception e)
            {
                System.out.println("puae3");
                printUsageAndExit();
                
            }
            
            try
            {
                if (args[3].matches("K"))
                {
                    printGrids = true;
                }
                else if (args[3].matches("E"))
                {
                    printGrids = false;
                }
                else
                {
                    System.out.println("puae4");
                    printUsageAndExit();
                }
            }
            catch (Exception e)
            {
                System.out.println("puae5");
                printUsageAndExit();
            }
            
        }
        else
        {
            System.out.println("puae6");
            printUsageAndExit();
        }
            
        
        if (mode == 1)
        {
            String gridInString = readInputToString(fileName);
            Grid gridi = createGridFromString(gridInString);
            
            if (gridi == null)
            {
                System.out.println("puae7");
                printUsageAndExit();
            }
            
            System.out.println("Käsiteltävä sokkelo: ");
            System.out.println(createBorder(gridi));
            System.out.println(gridi.toString());
            System.out.println(createBorder(gridi));
            System.out.println();
            

            if(usedAlgos.matches("M") || usedAlgos.matches("A"))
            {
                runAStar(gridi, printGrids, usedHeurs);                
            }
            
	    gridi.resetGrid(false);

            if (usedAlgos.matches("M") || usedAlgos.matches("D"))
            {
                runDijkstra(gridi, printGrids);
            }    
        }
        else if (mode == 2)
        {   
            for (int i = 0; i < timesToLoop; i++)
            {
                Grid gridi = new Grid(175, 175);
                System.out.println("Kierros: " + (i+1));
                gridi.setRandomStartAndGoal();
                gridi.createInpassables();

                if (printGrids == true)
                {
                    System.out.println("Käsiteltävä sokkelo: ");
                    System.out.println(createBorder(gridi));
                    System.out.println(gridi.toString());
                    System.out.println(createBorder(gridi));
                    System.out.println();                
                }
                runAStar(gridi, printGrids, "E");
                gridi.resetGrid(false);
                runAStar(gridi, printGrids, "M");
                gridi.resetGrid(false);
                runDijkstra(gridi, printGrids);
                System.out.println("=================================");
                System.out.println();
                gridi = null;
            }
        }
        else
        {
            System.out.println("Jotain on pahasti pielessä...");
            System.exit(-1);
        } 
    }
    
    /**
     * Method to first print out the user guide of the program and then exit. 
     */
    private static void printUsageAndExit()
    {
        System.out.println("Sovellusta voi ajaa usealla eri tavalla: ");
        System.out.println("1. java -jar DijkstraStarVertailuApp.java -f <tiedosto> -a <A/D/M> -h <M/E>" );
        System.out.println("     Tämä on sovelluksen 'normaalimoodi', jossa käyttäjä syöttää läpikäytävän sokkelon tiedostona ja ohjelma selvittää lyhyimmän reitin sokkelon läpi.");
        System.out.println("     -f -valitsimella ohjelmalle syötetään sokkelon sisältävän tekstitiedoston nimi polkuineen.");
        System.out.println("     Tiedostossa kuvatun sokkelon on oltava suorakulmion muotoinen, sekä sallittuja merkkejä sokkelon kuvauksessa ovat:");
        System.out.println("       X = Läpikäynnin alkupiste. Tämä on pakollinen tieto.");
        System.out.println("       O = Läpikäynnin päätepiste. Tämä on pakollinen tieto.");
        System.out.println("       # = Este");
        System.out.println("       . = Avoin tila");
        System.out.println("     Mikäli sokkelossa on muita merkkejä, ohjelma muuttaa ne automaattisesti pisteiksi kuvaamaan avointa tilaa.");
        System.out.println();
        System.out.println("     -a -valitsimella ohjataan mitä algoritmia ohjelma käyttää sokkelon läpikäynnissä.");
        System.out.println("     Vaihtoehdot ovat:");
        System.out.println("       A = A* -algoritmi");
        System.out.println("       D = Dijkstran algoritmi");
        System.out.println("       M = Molemmat edellämainituista");
        System.out.println("     Mikäli -f -valitsin on annettu, mutta -a -valitsinta ei, sovellus käyttää oletuksena M -optiota. ");
        System.out.println();
        System.out.println("     -h -valitsimella ohjataan mitä heuristiikkaa käytetään A* -algoritmin kanssa.");
        System.out.println("     Vaihtoehdot ovat:");
        System.out.println("       M = Manhattan");
        System.out.println("       E = Euklidinen");
        System.out.println("     Mikäli -a -valitsimella on valittu käytettäväksi Dijkstran algoritmi, -h -valitsimella ei ole merkitystä.");
        System.out.println("     Mikäli -a -valitsimella on valittu käytettäväksi A* -algoritmi, mutta -h -valitsin on tyhjä, oletuksena käytetään Euklidista heuristiikkaa.");
        System.out.println();
        System.out.println();
        System.out.println("2. java -jar DijkstraStarVertailuApp.java -t <kokonaisluku> -p <K/E>");
        System.out.println("     Tämä on sovelluksen testausmoodi.");
        System.out.println("     Sovellus generoi käyttäjän antaman määrän satunnaisia sokkeloita, joille kaikille se hakee reitin ");
        System.out.println("     sekä A*- että Dijkstran algoritmeillä ja tulostaa läpikäyntiin kuluneen ajan ja löytyneen reitin pituuden (jos reitti löytyi).");
        System.out.println("     A* -algoritmillä käytetään sekä Manhattan- että Euklidista heuristiikkaa.");
        System.out.println("     Valinnaisesti tulostetaan läpikäydyt sokkelot.");
        System.out.println("     -t -valitsimella kerrotaan kuinka monta sokkeloa ohjelma generoi läpikäytäväksi");
        System.out.println();
        System.out.println("     -p -valitsimella kerrotaan tulostetaanko läpikäytävät sokkelot ruudulle");
        System.out.println("     Vaihtoehdot ovat:");
        System.out.println("     K = Kyllä");
        System.out.println("     E = Ei");
        System.out.println("     (HUOM! Mikäli -t -valitsimen arvo on kovinkin suuri, -p -valitsimen käyttö tuottaa tulostetta varsin suuria määriä.)");
        System.out.println();
        System.out.println("Huomaa, että kaikki parametrit ja valitsimet ovat case-sensitiivisiä.");
    
        System.exit(0);
    }

    /**
     * Method for reading a file into a string.
     * @param fileName The name of the file to be read.
     * @return the contents of the file in a string, with line breaks.
     */
    private static String readInputToString(String fileName)
    {
        File inFile = new File(fileName);
        Scanner reader = null;
        StringBuilder gridInAString = new StringBuilder();
                    
        try
        {
            reader = new Scanner(new BufferedReader(new FileReader(inFile)));
            reader.useDelimiter("\r\n|\n|\r");
                
            while (reader.hasNext())
            {
                gridInAString.append(reader.next());
                gridInAString.append("\n");
            }
            
            gridInAString.deleteCharAt(gridInAString.length()-1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        
        return gridInAString.toString();
            
        
    }

    /**
     * Method for creating a Grid from a String
     * @param gridInString A grid store in a string
     * @return A grid.
     */
    private static Grid createGridFromString(String gridInString) 
    {
        int rows = 1;
        int columns = 1;
        boolean columnsOK        = false;
        boolean startSet         = false;
        boolean goalSet          = false;
        
        //Lets see how many rows & columns we have
        for (int i = 0; i < gridInString.length(); i++)
        {
            if (gridInString.charAt(i)== '\n' && columnsOK == false)
            {
                columns=i;
                columnsOK = true;
            }
            else if (gridInString.charAt(i)== '\n')
            {
                rows++;
            }
        }
        rows++;
        
        Grid grid = new Grid(rows, columns);
        
        rows = 0;
        columns = 0;
        
        for (int i = 0; i < gridInString.length(); i++) 
        {   
            if (gridInString.charAt(i) == '\n')
            {
                rows++;
                columns=0;
                continue;
            }
            else if (gridInString.charAt(i) == 'X' && startSet == false)
            {
                grid.setStart(rows, columns);
                startSet = true;
            }
            else if (gridInString.charAt(i) == 'O' && goalSet == false)
            {
                grid.setGoal(rows, columns);
                goalSet = true;
            }
            else if (gridInString.charAt(i) == '#')
            {
                grid.setImpassable(rows, columns);
            }

            columns++;
        }

        if (goalSet == false || startSet == false)
        {
            return null;
        }
        
        return grid;
    }
    
    /**
     * Method for creating 'header & footer' for a Grid printed to the console. 
     */
    private static String createBorder(Grid grid)
    {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < grid.getColumns(); i++) 
        {
            str.append("=");
        }
        return str.toString();
    }

   /**
     * Method for starting the shortest path search using Dijkstras algorithm and reporting the results.
     * @param gridi The grid from which the shortest path is to be searched.
     * @param printGrids Control flag whether or not to print the resulting grids to the console.
     * @param heuristic  The heuristic to be used in the search.
     */
    private static void runAStar(Grid gridi, boolean printGrids, String heuristic) 
    {
        long   starStartTime     = 0;
        long   starEndTime       = 0;
        
        starStartTime = System.currentTimeMillis();
        gridi.findShortestPath("A", heuristic);
        starEndTime = System.currentTimeMillis();
                
        System.out.println("A* -algoritmin tulos:");

        if (printGrids == true)
        {
            System.out.println(createBorder(gridi));
            System.out.println(gridi.toString());
            System.out.println(createBorder(gridi));
        }
        System.out.println("Reitin pituus.........: " + gridi.getGoal().getfScore());
        System.out.println("Aikaa kului...........: " + (starEndTime - starStartTime) + " ms.");
        if (!heuristic.isEmpty())
        {
            System.out.println("Käytetty heuristiikka.: " + heuristic);
        }
        
        System.out.println();
    }

    /**
     * Method for starting the shortest path search using Dijkstras algorithm and reporting the results.
     * @param gridi The grid from which the shortest path is to be searched.
     * @param printGrids Control flag whether or not to print the resulting grids to the console.
     */
    private static void runDijkstra(Grid gridi, boolean printGrids) 
    {
        long   dijkstraStartTime = 0;
        long   dijkstraEndTime   = 0; 
        
        dijkstraStartTime = System.currentTimeMillis();
        gridi.findShortestPath("D", "");
        dijkstraEndTime = System.currentTimeMillis();
        System.out.println("Dijkstran algoritmin tulos:");

        if (printGrids == true)
        {
            System.out.println(createBorder(gridi));
            System.out.println(gridi.toString());
            System.out.println(createBorder(gridi));
        }
        System.out.println("Reitin pituus.: " + gridi.getGoal().getfScore());
        System.out.println("Aikaa kului...: " + (dijkstraEndTime - dijkstraStartTime) + " ms.");

    }
    
}
