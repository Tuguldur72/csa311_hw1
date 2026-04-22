# csa311_hw1



Төслийн нэр: Flashcard System (CSA311 - Homework 1)

Оюутны мэдээлэл: А. Төгөлдөр B242270001

Ажиллуулах заавар: ```bash
cd .\flashcard-system\
mvn clean package
java -cp target/flashcard-system-1.0-SNAPSHOT.jar mn.edu.num.csa311.Main cards.txt --order recent-mistakes-first

Хэрэгжүүлсэн боломжууд: CLI аргументууд, RecentMistakesFirst логик, 3 төрлийн амжилтууд (CORRECT, REPEAT, CONFIDENT) гэх мэт.

If you wanted get help, write --help before you start the game like this:
java -cp target/flashcard-system-1.0-SNAPSHOT.jar mn.edu.num.csa311.Main cards.txt --help

Or you can just use it
("Flashcard System");
("Usage: java -cp target/classes mn.edu.num.csa311.Main <cards-file> [options]");
("Options:");
("  --help                Show help information");
("  --order <order>       Set card order [random, worst-first, recent-mistakes-first]");
("  --repetitions <num>   Set how many times a card must be answered correctly");
("  --invertCards         Swap questions and answers");

All output and input changed into english due to encoding.
