package com.wildernessdrtech;

import java.util.ArrayList;
import java.util.Comparator;

public class Gene {
    private ArrayList<Codon> codons = new ArrayList<>();

    public enum Nucleotide{
        A,C,G,T
    }
    public static class Codon implements Comparable<Codon> {
        public final Nucleotide first, second, third;
        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.first)
                .thenComparing((Codon c) -> c.second)
                .thenComparing((Codon c) -> c.third);

        public Codon(String condonStr) {
            first = Nucleotide.valueOf(condonStr.substring(0, 1));
            second = Nucleotide.valueOf(condonStr.substring(1, 2));
            third = Nucleotide.valueOf(condonStr.substring(2, 3));
        }

        @Override
        public int compareTo(Codon other) {
            return comparator.compare(this, other);
        }
    }
        public boolean linearContains(Codon key) {
            for (Codon codon : codons) {
                if (codon.compareTo(key) == 0) {
                    return true;
                }
            }
            return false;
        }

    public Gene(String geneStr){
        for(int i = 0; i < geneStr.length() - 3; i +=3){
            codons.add(new Codon(geneStr.substring(i,i+3)));
        }
    }
    public void main(){
        String geneStr = "ACGTACGGATCTCGATCTAACG";
        Gene myGene = new Gene(geneStr);
        Codon acg = new Codon("ACG");
        Codon gat = new Codon("GAT");
        System.out.println(myGene.linearContains(acg));
        System.out.println(myGene.linearContains(gat));
    }



}
