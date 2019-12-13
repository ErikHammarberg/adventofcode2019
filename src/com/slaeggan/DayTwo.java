package com.slaeggan;

import java.util.Arrays;

public class DayTwo {
    private static final String INPUT = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,1,19,6,23,2,23,6,27,2,6,27,31,2,13,31,35,1,9,35,39,2,10,39,43,1,6,43,47,1,13,47,51,2,6,51,55,2,55,6,59,1,59,5,63,2,9,63,67,1,5,67,71,2,10,71,75,1,6,75,79,1,79,5,83,2,83,10,87,1,9,87,91,1,5,91,95,1,95,6,99,2,10,99,103,1,5,103,107,1,107,6,111,1,5,111,115,2,115,6,119,1,119,6,123,1,123,10,127,1,127,13,131,1,131,2,135,1,135,5,0,99,2,14,0,0";

    public int doWork1() {
        var ints = Arrays.stream(INPUT.split(",")).mapToInt(Integer::parseInt).toArray();
        ints[1] = 12;
        ints[2] = 2;
        var computer = new IntComputer(ints);
        return computer.execute();
    }

    class IntComputer {
        int[] mem;
        int opCounter;

        public IntComputer(int[] mem) {
            this.mem = mem;
        }

        public int execute() {
            for (; mem[opCounter] != 99; opCounter += 4) {
                switch (mem[opCounter]) {
                    case 1:
                        add(mem[opCounter + 1], mem[opCounter + 2], mem[opCounter + 3]);
                        break;
                    case 2:
                        multiply(mem[opCounter + 1], mem[opCounter + 2], mem[opCounter + 3]);
                        break;
                    default:
                        throw new RuntimeException("Faulty code: " + mem[opCounter]);
                }
            }
            return mem[0];
        }

        private void add(int pos1, int pos2, int resPos) {
            mem[resPos] = mem[pos1] + mem[pos2];
        }

        private void multiply(int pos1, int pos2, int resPos) {
            mem[resPos] = mem[pos1] * mem[pos2];
        }
    }
}
