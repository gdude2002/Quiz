package com.github.quiz;

import java.util.Arrays;
import java.util.HashMap;

public class Questions {
    private final HashMap<String, HashMap<String, Object>> questions;

    public Questions() {
        this.questions = new HashMap<>();

        this.addQuestion(
                "How many times Have Manchester United won the F.A. Cup?",  // Question
                3,  // Correct index
                "8", "9", "10", "11"  // Answers
        );


        this.addQuestion(
                "Who holds the record for the most losses in total in the English Soccer Leagues History?",
                4,
                "Burnley", "Sunderland", "Norwich", " Everton"
        );

        this.addQuestion(
                "Who is the world cups all time top goal scorer?",
                3,
                "Pele", "Ronaldo", "Miroslav Klose", "Gerd Mueller"
        );

        this.addQuestion(
                " Who holds the record for most Premier League goals??",
                1,
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"
        );

        this.addQuestion(
                " How many clubs have won the Champions League 5 or more times?",
                3,
                "2", "3", "4", "5"
        );

        this.addQuestion(
                "Which english club knocked both Liverpool F.C. and Chealsea F.C. out of the 2007/2008 FA Cup?",
                4,
                " Bradford", "Burnley", "Manchester United", "Barnsley"
        );

        this.addQuestion(
                "Who holds the record for most Premier League goals?",  // Question
                0,  // Correct index
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"  // Answers
        );

        this.addQuestion(
                "Who is Ireland rugby’s all time highest scorer",
                1,
                "Ronan O’ Gara", " Brian O’ Driscoll", "John  Hayes", " Keith Wood"
        );

        this.addQuestion(
                "How many clubs have won the Champions League 5 or more times?",  // Question
                2,  // Correct index
                "2", "3", "4", "5"  // Answers
        );

        this.addQuestion(
                "Who where the 1st winners of the All-Ireland Senior Football Championship held in 1887?",
                4,
                "Kerry", "Dublin", "Galway", "Limerick"
        );

        this.addQuestion(
                "Which english club knocked both Liverpool F.C. and Chelsea F.C. out of the 2007/2008 FA Cup?",  // Question
                3,  // Correct index
                "Bradford", "Burnley", "Manchester United", "Barnsley"  // Answers
                "Kerry hold the record amount of All Ireland Championships won at 37, But who are the 2nd Highest?",
                3,
                "Galway", "Cork", "Dublin", "Meath"
        );

        this.addQuestion(
                "The fastest goal in All Ireland History was scored in just 49 seconds but by who?",
                2,
                "Michael Murphy(Donegal)", "Paul Geaney(Kerry)", "Dara O Cinneide(Kerry)", " Alan Dillon(Mayo)"
        );

        this.addQuestion(
                "What is he highest grossing game in history?",
                3,
                "Minecraft", "Grand Theft Auto 5", "Tetris", " Wii Sports"
        );

        this.addQuestion(
                "Which video game console currently has the longest life span according to official sales?",
                1,
                "Sega Master System", "Playstation 2", "Nintendo Entertainment System", " Gameboy"
        );

        this.addQuestion(
                "In the HALO series who is Master chief’s AI sidekick?",
                1,
                "Cortana", "Arbiter", "343 Guilty Spark", " HAL"
        );

        this.addQuestion(
                "What game marks the 1st ever appearance of Super Mario",
                4,
                "Super Mario Brothers", "Mario cart", "Super Mario Land", " Donkey Kong"
        );

        this.addQuestion(
                "Dhalsim is character in which game series?",
                3,
                "Mortal Kombat", "Fight Night", "Street Fighter", " Tekken"
        );

        this.addQuestion(
                "Resident evil is known by a different name in Japan what is it?",
                2,
                "Evil Dead", " Biohazard ", "Walking dead", " Alone in the dark"
        );

        this.addQuestion(
                "What Planet is the game series Doom set on??",
                3,
                "Earth", "Venus ", "Mars", "Uranus"
        );

        this.addQuestion(
                "Mario’s original name is what?",
                2,
                "Luigi", "Jump man", "Plumber man", "Red man"
        );

        this.addQuestion(
                "What is the name of the original assassin you control in the 1st 'Assassins Creed' game?",
                4,
                "Ezio", "Connor", "Shay", "Altair"
        );

        this.addQuestion(
                "How may planets in our solar system have rings?",
                4,
                "1", "2", "3", "4"
        );

        this.addQuestion(
                "Which year does Michael J Fox travel back to in Back to the Future?",
                2,
                "1950", "1955", "1960", "1965"
        );

        this.addQuestion(
                "In a game of scrabble how many points is a Q tile worth?",
                4,
                "3", "5", "8", "10"
        );

        this.addQuestion(
                "What is the name of cartoon character SpongeBob Squarepants pet snail?",
                3,
                "Larry", "John", "Gary", "David"
        );

        this.addQuestion(
                "What was the name of the camp which was set up in Chile when 30 miners where trapped underground?",
                2,
                "Freedom", "Hope", "Faith", "Peace"
        );

        this.addQuestion(
                "Which actor portrayed James Bond in the 1st film Dr. No?",
                1,
                "Sean Connery", "George Lazenby", "Roger Moore", "Timothy Dalton"
        );

        this.addQuestion(
                "Upcoming James Bond Movie \"Spectre\" will mark how many Official movies in the series?",
                4,
                "21", "22", "23", "24"
        );

        this.addQuestion(
                "How many time zones does Russia have?",
                1,
                "9", "8", "7", "6"
        );

        this.addQuestion(
                "Which Country has the internet domain '.ch'?",
                2,
                "China", "Switzerland", "Australia", "Russia"
        );

        this.addQuestion(
                "What is the name of the ship in the novel 'Treasure Island' by Robert Louis Stevenson??",
                1,
                "Hispaniola", "Jackdaw", "Aquila", "Morrigan"
        );

        this.addQuestion(
                "In the Avengers comics and movies who is referred too as the 1st avenger?",
                4,
                "Iron Man", "Thor", "Nick Fury", "Captain America"
        );

        this.addQuestion(
                "Texas Hold'Em is a variation of which card game?",
                2,
                "Solitaire", "Poker", "Bridge", "Freecell"
        );

        this.addQuestion(
                " What colour are the stars on the national flag of China?",
                1,
                "Yellow", "Red", "White", "Blue"
        );

        this.addQuestion(
                "Anime is a film animation originated in which country?",
                3,
                "China", "Korea", "Japan", "India"
        );

        this.addQuestion(
                "In UK currency how many sides does a twenty pence piece have?",
                4,
                "4", "5", "6", "7"
        );

        this.addQuestion(
                "Who did Germany beat too win the 2014 World Cup?",
                4,
                "Uruguay", "Brazil", "Holland", "Argentina"
        );

        this.addQuestion(
                "How many states are there in the United State of America?",
                2,
                "49", "50", "51", "52"
        );

        this.addQuestion(
                "What year did the cold war officially end?",
                4,
                "1985", "1987", "1989", "1991"
        );

        this.addQuestion(
                "What was the name of the butler in the U.S. tv series ‘The Fresh Prince of Bel Air’, starring Will Smith?",
                1,
                "Geoffrey", " Winston", "Alfred", "Giles"
        );
        this.addQuestion(
                " What is the zodiac sign for someone born on the 15th of May?",
                3,
                "Aquirius", "Cancer", "Taurus", "Gemini"

        );
        this.addQuestion(
                "Insurgents of what nation took park in the 1916 Easter rising?",
                2,
                "England", "Ireland", "Spain", "France"
        );
        this.addQuestion(
                "Which country originated the motor scooter?",
                4,
                "France", "Spain", "Germany", "Italy"
        );
        this.addQuestion(
                "The majority of the amazon rain forest is contained within which country?",
                1,
                "Brazil", "Argentina", "Columbia", "Chile"
        );
        this.addQuestion(
                "In which decade in the 1900’s did Sir Edmond Hilary reach the summit of Mount Everest?",
                2,
                "1940's", "1950's", "1960's", "1970's"
        );
        this.addQuestion(
                "What is the title of the 1977 film Star Wars Episode IV?",
                2,
                "Reurn of the Jedi", "A New Hope", "The Empire Strikes Back", "Revenge of the Sith"
        );
        this.addQuestion(
                "In the US television series, what type of car did Starsky and Hutch drive?",
                1,
                "Gran Turino", "Dodge Charger", "Ford Mustang", "Corvette Stingray"
        );
        this.addQuestion(
                "Which is the US television fantasy drama set in the fictional seven Kingdoms of Westeros?",
                3,
                "The Walking Dead", "Breaking Bad", "Game of thrones", "Lord of the rings"
        );
        this.addQuestion(
                "Which car manufacturer has a logo with overlapping letter ‘R’s’?",
                2,
                "Range Rover", "Rolls Royce", "Rover", "Reliant Robin"
        );
        this.addQuestion(
                "Lake Mamry and Lake Drawsko are in which European country??",
                2,
                "Finland", "Poland", "Czech Republic", "Norway"
        );
    }

    /**
     * Add a question.
     *
     * @param question The question itself, including question mark
     * @param correctIndex The array index for the correct answer - starts at 0!
     * @param answers The answers themselves, as a set of String arguments
     */
    public void addQuestion(String question, Integer correctIndex, String ... answers) {
        HashMap<String, Object> questionMap = new HashMap<>();
        questionMap.put("answers", Arrays.asList(answers));
        questionMap.put("correct", answers[correctIndex]);

        this.questions.put(question, questionMap);
    }
}
