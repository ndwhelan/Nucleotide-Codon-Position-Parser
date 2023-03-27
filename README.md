# NucleotideCodonParser

(!) Disclaimer: This is a very basic and not well tested program. It should work, but it's not very user friendly. It will probably fail with an unclear error if something is wrong. I am personally unable to provide any support. (!)

This program takes any alignment in .FASTA format and splits the sequences up by position in the codon.  The output is three files with the alignment parsed by position in the codon.  The user should know when the reading frame starts (pos.1,2 or 3 in the alignment) as the program puts position 1,4, 7, etc, of the alignment into the first file.  This program is ideal for preparing alignment files for testing models of molecular evolution by codon position for phylogenetics using a standard model testing program.

# Running

## Compiling

```
> javac NucleotideCodonParser.java
```

## Running

```
java NucleotideCodonParser my_sequence.FASTA
```