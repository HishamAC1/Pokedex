import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

public class PokemonTable {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Original 151 Pokémon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Pokémon data (ID, Name, Type)
        String[][] pokemonData = {
                {"001", "Bulbasaur", "Grass/Poison"},
                {"002", "Ivysaur", "Grass/Poison"},
                {"003", "Venusaur", "Grass/Poison"},
                {"004", "Charmander", "Fire"},
                {"005", "Charmeleon", "Fire"},
                {"006", "Charizard", "Fire/Flying"},
                {"007", "Squirtle", "Water"},
                {"008", "Wartortle", "Water"},
                {"009", "Blastoise", "Water"},
                {"010", "Caterpie", "Bug"},
                {"011", "Metapod", "Bug"},
                {"012", "Butterfree", "Bug/Flying"},
                {"013", "Weedle", "Bug/Poison"},
                {"014", "Kakuna", "Bug/Poison"},
                {"015", "Beedrill", "Bug/Poison"},
                {"016", "Pidgey", "Normal/Flying"},
                {"017", "Pidgeotto", "Normal/Flying"},
                {"018", "Pidgeot", "Normal/Flying"},
                {"019", "Rattata", "Normal"},
                {"020", "Raticate", "Normal"},
                {"021", "Spearow", "Normal/Flying"},
                {"022", "Fearow", "Normal/Flying"},
                {"023", "Ekans", "Poison"},
                {"024", "Arbok", "Poison"},
                {"025", "Pikachu", "Electric"},
                {"026", "Raichu", "Electric"},
                {"027", "Sandshrew", "Ground"},
                {"028", "Sandslash", "Ground"},
                {"029", "Nidoran♀", "Poison"},
                {"030", "Nidorina", "Poison"},
                {"031", "Nidoqueen", "Poison/Ground"},
                {"032", "Nidoran♂", "Poison"},
                {"033", "Nidorino", "Poison"},
                {"034", "Nidoking", "Poison/Ground"},
                {"035", "Clefairy", "Fairy"},
                {"036", "Clefable", "Fairy"},
                {"037", "Vulpix", "Fire"},
                {"038", "Ninetales", "Fire"},
                {"039", "Jigglypuff", "Normal/Fairy"},
                {"040", "Wigglytuff", "Normal/Fairy"},
                {"041", "Zubat", "Poison/Flying"},
                {"042", "Golbat", "Poison/Flying"},
                {"043", "Oddish", "Grass/Poison"},
                {"044", "Gloom", "Grass/Poison"},
                {"045", "Vileplume", "Grass/Poison"},
                {"046", "Paras", "Bug/Grass"},
                {"047", "Parasect", "Bug/Grass"},
                {"048", "Venonat", "Bug/Poison"},
                {"049", "Venomoth", "Bug/Poison"},
                {"050", "Diglett", "Ground"},
                {"051", "Dugtrio", "Ground"},
                {"052", "Meowth", "Normal"},
                {"053", "Persian", "Normal"},
                {"054", "Psyduck", "Water"},
                {"055", "Golduck", "Water"},
                {"056", "Mankey", "Fighting"},
                {"057", "Primeape", "Fighting"},
                {"058", "Growlithe", "Fire"},
                {"059", "Arcanine", "Fire"},
                {"060", "Poliwag", "Water"},
                {"061", "Poliwhirl", "Water"},
                {"062", "Poliwrath", "Water/Fighting"},
                {"063", "Abra", "Psychic"},
                {"064", "Kadabra", "Psychic"},
                {"065", "Alakazam", "Psychic"},
                {"066", "Machop", "Fighting"},
                {"067", "Machoke", "Fighting"},
                {"068", "Machamp", "Fighting"},
                {"069", "Bellsprout", "Grass/Poison"},
                {"070", "Weepinbell", "Grass/Poison"},
                {"071", "Victreebel", "Grass/Poison"},
                {"072", "Tentacool", "Water/Poison"},
                {"073", "Tentacruel", "Water/Poison"},
                {"074", "Geodude", "Rock/Ground"},
                {"075", "Graveler", "Rock/Ground"},
                {"076", "Golem", "Rock/Ground"},
                {"077", "Ponyta", "Fire"},
                {"078", "Rapidash", "Fire"},
                {"079", "Slowpoke", "Water/Psychic"},
                {"080", "Slowbro", "Water/Psychic"},
                {"081", "Magnemite", "Electric/Steel"},
                {"082", "Magneton", "Electric/Steel"},
                {"083", "Farfetch’d", "Normal/Flying"},
                {"084", "Doduo", "Normal/Flying"},
                {"085", "Dodrio", "Normal/Flying"},
                {"086", "Seel", "Water"},
                {"087", "Dewgong", "Water/Ice"},
                {"088", "Grimer", "Poison"},
                {"089", "Muk", "Poison"},
                {"090", "Shellder", "Water"},
                {"091", "Cloyster", "Water/Ice"},
                {"092", "Gastly", "Ghost/Poison"},
                {"093", "Haunter", "Ghost/Poison"},
                {"094", "Gengar", "Ghost/Poison"},
                {"095", "Onix", "Rock/Ground"},
                {"096", "Drowzee", "Psychic"},
                {"097", "Hypno", "Psychic"},
                {"098", "Krabby", "Water"},
                {"099", "Kingler", "Water"},
                {"100", "Voltorb", "Electric"},
                {"101", "Electrode", "Electric"},
                {"102", "Exeggcute", "Grass/Psychic"},
                {"103", "Exeggutor", "Grass/Psychic"},
                {"104", "Cubone", "Ground"},
                {"105", "Marowak", "Ground"},
                {"106", "Hitmonlee", "Fighting"},
                {"107", "Hitmonchan", "Fighting"},
                {"108", "Lickitung", "Normal"},
                {"109", "Koffing", "Poison"},
                {"110", "Weezing", "Poison"},
                {"111", "Rhyhorn", "Ground/Rock"},
                {"112", "Rhydon", "Ground/Rock"},
                {"113", "Chansey", "Normal"},
                {"114", "Tangela", "Grass"},
                {"115", "Kangaskhan", "Normal"},
                {"116", "Horsea", "Water"},
                {"117", "Seadra", "Water"},
                {"118", "Goldeen", "Water"},
                {"119", "Seaking", "Water"},
                {"120", "Staryu", "Water"},
                {"121", "Starmie", "Water/Psychic"},
                {"122", "Mr. Mime", "Psychic/Fairy"},
                {"123", "Scyther", "Bug/Flying"},
                {"124", "Jynx", "Ice/Psychic"},
                {"125", "Electabuzz", "Electric"},
                {"126", "Magmar", "Fire"},
                {"127", "Pinsir", "Bug"},
                {"128", "Tauros", "Normal"},
                {"129", "Magikarp", "Water"},
                {"130", "Gyarados", "Water/Flying"},
                {"131", "Lapras", "Water/Ice"},
                {"132", "Ditto", "Normal"},
                {"133", "Eevee", "Normal"},
                {"134", "Vaporeon", "Water"},
                {"135", "Jolteon", "Electric"},
                {"136", "Flareon", "Fire"},
                {"137", "Porygon", "Normal"},
                {"138", "Omanyte", "Rock/Water"},
                {"139", "Omastar", "Rock/Water"},
                {"140", "Kabuto", "Rock/Water"},
                {"141", "Kabutops", "Rock/Water"},
                {"142", "Aerodactyl", "Rock/Flying"},
                {"143", "Snorlax", "Normal"},
                {"144", "Articuno", "Ice/Flying"},
                {"145", "Zapdos", "Electric/Flying"},
                {"146", "Moltres", "Fire/Flying"},
                {"147", "Dratini", "Dragon"},
                {"148", "Dragonair", "Dragon"},
                {"149", "Dragonite", "Dragon/Flying"},
                {"150", "Mewtwo", "Psychic"},
                {"151", "Mew", "Psychic"}
        };

        // Column names
        String[] columnNames = {"ID", "Name", "Type"};

        // Create a JTable
        JTable table = new JTable(pokemonData, columnNames);

        // Add sorting functionality
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add search bar
        JTextField searchField = new JTextField();
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            private void search() {
                String text = searchField.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });

        frame.add(searchField, BorderLayout.NORTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}