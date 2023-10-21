package br.ufpb.dcx.datastructures.main;

import br.ufpb.dcx.datastructures.hash.*;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int p = input.nextInt();
        int k = input.nextInt();
        while (!((p >= 1 && p <= 20) && (k >= 1 && k <= 100))) {
            p = input.nextInt();
            k = input.nextInt();
        }

        HashTable<Integer> hashTable = new LinkedHashTable<>(p);
        for (int i = 0; i < k; i++) {
            int c = input.nextInt();
            hashTable.put(c);
        }
        System.out.println(hashTable);
        input.close();
    }

}