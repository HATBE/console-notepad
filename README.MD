# Commands
## ADD
- ADD [n]

inputs are filtered

Adds a paragraph on line n, if no line number is given, add a new at the bottom

![](./.img/1.png)

## DEL
- DEL [n]

Deletes line n, if no line number is given, remove the last line

![](./.img/2.png)

## DUMMY
- DUMMY [n]

![](./.img/3.png)

Adds a pre-defined dummy text on line n, if no line number is given, add a new line at the bottom

## FORMAT
- format raw
- format fix <b>

Change format of print
- fix = no line numbering, linebreak on b'th character
- raw = no line breaks, with line numbering

![](./.img/7.png)

![](./.img/4.png)

## REPLACE
- REPLACE [n]

inputs are filtered

Replaces a word or phrase on line n, if no line number is given, replace words in the last line

![](./.img/5.png)

## INDEX
- INDEX

Outputs an index (word index) of all terms that occur more than three times across all paragraphs. A term begins with a capital letter. The index lists the paragraphs in which the respective term occurs as a comma-separated sequence of numbers.

![](./.img/9.png)

## EXIT
- EXIT

exits program

![](./.img/6.png)

# Error handling

All foreseen errors are handled.

Example:

![](./.img/8.png)