package com.github.quiz;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Our main questions storage object. Not only does this deal with loading up the
 * questions, but it also saves the default set to a json file if one doesn't already
 * exist, and will load from there in the future.
 *
 * This allows someone to modify the set of questions, if they so please, by editing the
 * questions.json file.
 *
 * We used Google Gson for this, as it makes this kind of thing a whole lot easier.
 */
class Storage {
    // Because of the way Java does its strict types, we need one of these funky type tokens.
    private final Type token = new TypeToken<HashMap<String, HashMap<String, Object>>>(){}.getType();

    // This is our Gson parser and reader. It does pretty printing to the file is human-readable.
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File fh;

    public Storage() {
        // Open the file.
        // Seriously, that's all the constructor does.
        this.fh = new File("questions.json");
    }

    /**
     * Load up the questions, if possible.
     * @return HashMap of questions, or null if there was an error.
     */
    public HashMap<String, HashMap<String, Object>> load() {
        if (!this.fh.exists()) {  // If the file doesn't exists..
            // Insert defaults into it
            this.save(this.defaultQuestions());
        }

        /**
         * The below is one of Java's new try clauses. You're able to set up
         * things like stream handlers, and they'll be closed and cleaned up
         * when the try block is exited.
         */
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(this.fh),
                Charset.forName("UTF-8"))
            ) {  // Java requires a lot of abstractions and wrapper classes. >.>
            return this.gson.fromJson(reader, this.token);  // Simple enough, just load the data into a HashMap.
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // There was a problem, return null!
        }
    }

    /**
     * Save a set of questions to file.
     * @param questions HashMap of questions to save
     */
    void save(HashMap<String, HashMap<String, Object>> questions) {
        if (!this.fh.exists()) {
            // If the file doesn't exist, create it
            try {
                boolean created = this.fh.createNewFile();

                if (!created) {
                    return;  // If it couldn't be created, there's really not much we can do about it
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
               new FileOutputStream(this.fh, false),
               Charset.forName("UTF-8"))
            ) {
            gson.toJson(questions, writer);  // Write the questions to the stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return a HashMap of default questions.
     *
     * We did this in a function so that we wouldn't be wasting memory
     * when a questions file already exists (meaning we wouldn't need
     * to get the defaults from here).
     *
     * @return HashMap of the default questions
     */
    HashMap<String, HashMap<String, Object>> defaultQuestions() {
        HashMap<String, HashMap<String, Object>> questions = new HashMap<>();

        this.addQuestion(
                questions,  // The map to add the question to
                "How many times Have Manchester United won the F.A. Cup?",  // Question
                3,  // Correct index (zero-indexed)
                "8", "9", "10", "11"  // Answers
        );

        this.addQuestion(
                questions,
                "Who holds the record for the most losses in total in the English Soccer Leagues History?",
                3,
                "Burnley", "Sunderland", "Norwich", "Everton"
        );

        this.addQuestion(
                questions,
                "Who is the world cups' all-time top goal-scorer?",
                2,
                "Pele", "Ronaldo", "Miroslav Klose", "Gerd Mueller"
        );

        this.addQuestion(
                questions,
                "Who holds the record for most Premier League goals?",
                0,
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"
        );

        this.addQuestion(
                questions,
                "How many clubs have won the Champions League 5 or more times?",
                2,
                "2", "3", "4", "5"
        );

        this.addQuestion(
                questions,
                "Which English club knocked both Liverpool F.C. and Chelsea F.C. out of the 2007/2008 FA Cup?",
                3,
                "Bradford", "Burnley", "Manchester United", "Barnsley"
        );

        this.addQuestion(
                questions,
                "Who holds the record for most Premier League goals?",  // Question
                0,  // Correct index
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"  // Answers
        );

        this.addQuestion(
                questions,
                "Who is Ireland rugby's all time highest-scorer?",
                0,
                "Ronan O'Gara", "Brian O'Driscoll", "John Hayes", "Keith Wood"
        );

        this.addQuestion(
                questions,
                "How many clubs have won the Champions League 5 or more times?",  // Question
                2,  // Correct index
                "2", "3", "4", "5"  // Answers
        );

        this.addQuestion(
                questions,
                "Who where the 1st winners of the All-Ireland Senior Football Championship held in 1887?",
                3,
                "Kerry", "Dublin", "Galway", "Limerick"
        );

        this.addQuestion(
                questions,
                "Kerry hold the record amount of All Ireland Championships won at 37, But who are the second-highest?",
                2,
                "Galway", "Cork", "Dublin", "Meath"
        );

        this.addQuestion(
                questions,
                "The fastest goal in All Ireland History was scored in just 49 seconds but by who?",
                1,
                "Michael Murphy (Donegal)", "Paul Geaney (Kerry)", "Dara O Cinneide (Kerry)", "Alan Dillon (Mayo)"
        );

        this.addQuestion(
                questions,
                "What is the highest-grossing game in history?",
                2,
                "Minecraft", "Grand Theft Auto 5", "Tetris", "Wii Sports"
        );

        this.addQuestion(
                questions,
                "Which video game console currently has the longest lifespan, according to official sales?",
                0,
                "Sega Master System", "Playstation 2", "Nintendo Entertainment System", "Gameboy"
        );

        this.addQuestion(
                questions,
                "In the HALO series, who is Master chief's AI sidekick?",
                0,
                "Cortana", "Arbiter", "343 Guilty Spark", "HAL"
        );

        this.addQuestion(
                questions,
                "What game marks the first ever appearance of Super Mario?",
                3,
                "Super Mario Brothers", "Mario cart", "Super Mario Land", "Donkey Kong"
        );

        this.addQuestion(
                questions,
                "Dhalsim is character in which game series?",
                2,
                "Mortal Kombat", "Fight Night", "Street Fighter", "Tekken"
        );

        this.addQuestion(
                questions,
                "Resident evil is known by a different name in Japan. What is it?",
                1,
                "Evil Dead", "Biohazard ", "Walking dead", "Alone in the dark"
        );

        this.addQuestion(
                questions,
                "What Planet is the game series \"Doom\" set on?",
                2,
                "Earth", "Venus ", "Mars", "Uranus"
        );

        this.addQuestion(
                questions,
                "Mario's original name is what?",
                1,
                "Luigi", "Jump man", "Plumber man", "Red man"
        );

        this.addQuestion(
                questions,
                "What is the name of the original assassin you control in the first \"Assassin's Creed\" game?",
                3,
                "Ezio", "Connor", "Shay", "Altair"
        );

        this.addQuestion(
                questions,
                "How may planets in our solar system have rings?",
                3,
                "1", "2", "3", "4"
        );

        this.addQuestion(
                questions,
                "Which year does Michael J Fox travel back to in Back to the Future?",
                1,
                "1950", "1955", "1960", "1965"
        );

        this.addQuestion(
                questions,
                "In a game of scrabble, how many points is a Q tile worth?",
                3,
                "3", "5", "8", "10"
        );

        this.addQuestion(
                questions,
                "What is the name of cartoon character SpongeBob Squarepants' pet snail?",
                2,
                "Larry", "John", "Gary", "David"
        );

        this.addQuestion(
                questions,
                "What was the name of the camp which was set up in Chile when 30 miners where trapped underground?",
                1,
                "Freedom", "Hope", "Faith", "Peace"
        );

        this.addQuestion(
                questions,
                "Which actor portrayed James Bond in the first film, \"Dr. No\"?",
                0,
                "Sean Connery", "George Lazenby", "Roger Moore", "Timothy Dalton"
        );

        this.addQuestion(
                questions,
                "Upcoming James Bond Movie \"Spectre\" will mark how many official movies in the series?",
                3,
                "21", "22", "23", "24"
        );

        this.addQuestion(
                questions,
                "How many time zones does Russia have?",
                0,
                "9", "8", "7", "6"
        );

        this.addQuestion(
                questions,
                "Which country has the internet domain \".ch\"?",
                1,
                "China", "Switzerland", "Australia", "Russia"
        );

        this.addQuestion(
                questions,
                "What is the name of the ship in the novel \"Treasure Island\" by Robert Louis Stevenson?",
                0,
                "Hispaniola", "Jackdaw", "Aquila", "Morrigan"
        );

        this.addQuestion(
                questions,
                "In the Avengers comics and movies, who is referred to as the first avenger?",
                3,
                "Iron Man", "Thor", "Nick Fury", "Captain America"
        );

        this.addQuestion(
                questions,
                "Texas Hold'em is a variation of which card game?",
                1,
                "Solitaire", "Poker", "Bridge", "Freecell"
        );

        this.addQuestion(
                questions,
                "What colour are the stars on the national flag of China?",
                0,
                "Yellow", "Red", "White", "Blue"
        );

        this.addQuestion(
                questions,
                "\"Anime\" is a form of animation originating from which country?",
                2,
                "China", "Korea", "Japan", "India"
        );

        this.addQuestion(
                questions,
                "In UK currency, how many sides does a twenty pence piece have?",
                3,
                "4", "5", "6", "7"
        );

        this.addQuestion(
                questions,
                "Who did Germany beat to win the 2014 World Cup?",
                3,
                "Uruguay", "Brazil", "Holland", "Argentina"
        );

        this.addQuestion(
                questions,
                "How many states are there in the United State of America?",
                1,
                "49", "50", "51", "52"
        );

        this.addQuestion(
                questions,
                "What year did the cold war officially end?",
                3,
                "1985", "1987", "1989", "1991"
        );

        this.addQuestion(
                questions,
                "What was the name of the butler in the U.S. TV series \"The Fresh Prince of Bel Air\", starring Will Smith?",
                0,
                "Geoffrey", "Winston", "Alfred", "Giles"
        );
        this.addQuestion(
                questions,
                "What is the Zodiac sign for someone born on the 15th of May?",
                2,
                "Aquarius", "Cancer", "Taurus", "Gemini"

        );
        this.addQuestion(
                questions,
                "Insurgents of what nation took park in the 1916 Easter rising?",
                1,
                "England", "Ireland", "Spain", "France"
        );
        this.addQuestion(
                questions,
                "Which country created the motor scooter?",
                3,
                "France", "Spain", "Germany", "Italy"
        );
        this.addQuestion(
                questions,
                "The majority of the amazon rain forest is contained within which country?",
                0,
                "Brazil", "Argentina", "Columbia", "Chile"
        );
        this.addQuestion(
                questions,
                "In which decade in the 1900s did Sir Edmond Hilary reach the summit of Mount Everest?",
                1,
                "1940s", "1950s", "1960s", "1970s"
        );
        this.addQuestion(
                questions,
                "What is the title of the 1977 film \"Star Wars Episode IV\"?",
                1,
                "Return of the Jedi", "A New Hope", "The Empire Strikes Back", "Revenge of the Sith"
        );
        this.addQuestion(
                questions,
                "In the US television series, what type of car did Starsky and Hutch drive?",
                0,
                "Gran Turino", "Dodge Charger", "Ford Mustang", "Corvette Stingray"
        );
        this.addQuestion(
                questions,
                "Which is the US television fantasy drama set in the fictional Seven Kingdoms of Westeros?",
                2,
                "The Walking Dead", "Breaking Bad", "Game of Thrones", "Lord of the Rings"
        );
        this.addQuestion(
                questions,
                "Which car manufacturer has a logo with overlapping letter \"R\"s?",
                1,
                "Range Rover", "Rolls Royce", "Rover", "Reliant Robin"
        );
        this.addQuestion(
                questions,
                "Lake Mamry and Lake Drawsko are in which European country?",
                1,
                "Finland", "Poland", "Czech Republic", "Norway"
        );

        return questions;
    }

    /**
     * Add a question to a HashMap.
     *
     * @param questions The HashMap to add to
     * @param question The question, as a string
     * @param correctIndex The correct answer as a zero-indexed array index
     * @param answers The array of possible answers
     */
    void addQuestion(
            HashMap<String, HashMap<String, Object>> questions, String question, Integer correctIndex, String... answers
    ) {
        HashMap<String, Object> questionMap = new HashMap<>();
        questionMap.put("answers", Arrays.asList(answers));
        questionMap.put("correct", answers[correctIndex]);

        // As we're passing the map in by reference, we can just add the
        // question to it and not return anything.
        questions.put(question, questionMap);
    }
}
