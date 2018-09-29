
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.JOptionPane;

/*
 * /* Programmer: Tayyaab Tanveer
 * Date: May 13 2018
 * Name of Program: Sorting Efficiency Module 15
 * This program uses selection, bubble and insertion sorting over a variety of arraylist sizes to see which is most efficient.
 */
public class SortingEfficiencyM15 extends javax.swing.JFrame {
// Random function using recursion to generate random integers.

    public static int randomNum(int min, int max) {
        Random randInt = new Random();
        int randomNum = randInt.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    // declaring static int to count number of searches
    private static int selectionLoopCounter;
    private static int bubbleLoopCounter;
    private static int insertionLoopCounter;
    private static int selectionComparisonCounter;
    private static int bubbleComparisonCounter;
    private static int insertionComparisonCounter;
    private static int selectionShiftCounter;
    private static int bubbleShiftCounter;
    private static int insertionShiftCounter;
    private static long selectionTime;
    private static long bubbleTime;
    private static long insertionTime;
    // Create Int Type arrayList to hold the numbers to be sorted.
    ArrayList<Integer> numbers = new ArrayList();

// ASCENDING SELECTION SORT FUNCTION 
    public static void ascendingSortSelection(ArrayList<Integer> A) {
        //Starting Timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;
        //for loop that goes through each index
        for (int i = 0; i < A.size(); i++) {
            int pos = i;
            // nested for loop again going through each index. Finds smallest elemet
            for (int j = i; j < A.size(); j++) {
                counterLoop++;
                //find smallest element
                if (A.get(j) < A.get(pos)) {
                    counterComparison++;
                    // set new smallest element index.
                    pos = j;
                    counterShift++;
                }
            }
            //this swap will occur to switch positions and sort the list.
            // temp int will take the value of pos value
            int temp = A.get(pos);
            counterShift++;
            // then at index of position, index value of i will be set
            A.set(pos, A.get(i));
            counterShift++;
            // and vice versa, at index of i, temp value will be set
            A.set(i, temp);
            counterShift++;
        }
        //the static variables are set the the counting variables we used in the code.
        selectionLoopCounter = counterLoop;
        selectionComparisonCounter = counterComparison;
        selectionShiftCounter = counterShift;
        //end time counter and set time variable
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        selectionTime = elapsed;
    }
// DESCENDING SELECTION SORT FUNCTION

    public static void descendingSortSelection(ArrayList<Integer> A) {
        //Starting Timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();
        //Set counters
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;

        //for loop that goes through each index
        for (int i = 0; i < A.size(); i++) {
            int pos = i;
            // nested for loop again going through each index.
            for (int j = i; j > A.size(); j++) {
                counterLoop++;
                //find largest element
                if (A.get(j) < A.get(pos)) {
                    counterComparison++;
                    // set new largest element index. 
                    pos = j;
                    counterShift++;
                }
            }
            //this swap will occur to switch positions and sort the list.
            // temp int will take the value of pos value
            int temp = A.get(pos);
            counterShift++;
            // then at index of position, index value of i will be set
            A.set(pos, A.get(i));
            counterShift++;
            // and vice versa, at index of i, temp value will be set
            A.set(i, temp);
            counterShift++;
        }
        //the static variables are set the the counting variables we used in the code. 
        selectionLoopCounter = counterLoop;
        selectionComparisonCounter = counterComparison;
        selectionShiftCounter = counterShift;
        //end counter and set a time variable.
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        selectionTime = elapsed;
    }

    //RECURSIVE ASCENDING BUBBLE SORT FUNCTION
    public static void ascendingBubbleSort(ArrayList<Integer> A) {
        //start timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();

        //set counters
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;

        // for all elements of list
        for (int i = A.size() - 1; i >= 0; i--) {
            // it will compare adjacent indexes and then return back to the outer for loop above and run again.
            for (int j = 0; j < i; j++) {
                counterLoop++;
                // if index j element is lower than adjacent element
                if ((A.get(j)) < (A.get(j + 1))) {
                    counterComparison++;
                    //swap is performed  to make the greater element in position of j.
                    int temp = A.get(j);
                    counterShift++;
                    A.set(j, A.get(j + 1));
                    counterShift++;
                    A.set(j + 1, temp);
                    counterShift++;
                }
            }
        }
        //set counters to static variables
        bubbleLoopCounter = counterLoop;
        bubbleComparisonCounter = counterComparison;
        bubbleShiftCounter = counterShift;
        // end counter and set time variable
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        bubbleTime = elapsed;
    }

// RECURSIVE DESCENDING BUBBLE SORT FUNCTION
    public static void descendingBubbleSort(ArrayList<Integer> A) {
        //start timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();

        //set counters
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;

        // for all elements of list
        for (int i = A.size() - 1; i >= 0; i--) {
            // it will compare adjacent indexes and then return back to the outer for loop above and run again.
            for (int j = 0; j < i; j++) {
                counterLoop++;
                // if index j element is greater than adjacent element
                if ((A.get(j)) > (A.get(j + 1))) {
                    counterComparison++;
                    //swap is performed  to make the lower element in position of j.
                    int temp = A.get(j);
                    counterShift++;
                    A.set(j, A.get(j + 1));
                    counterShift++;
                    A.set(j + 1, temp);
                    counterShift++;
                }
            }
        }
        //set counters to static variables
        bubbleLoopCounter = counterLoop;
        bubbleComparisonCounter = counterComparison;
        bubbleShiftCounter = counterShift;
        // end counter and set time variable
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        bubbleTime = elapsed;
    }

//RECURSIVE ASCENDING INSERTION SORT FUNCTION
    public static void ascendingInsertionSort(ArrayList<Integer> A) {
        //start timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();

        //set int variables
        int k;
        int position;
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;

        //for all elements in list starting with second element
        for (int i = 1; i < A.size(); i++) {
            //set k to element at i index
            k = A.get(i);
            // position takes index i
            position = i;
            counterLoop++;
            // while position is greater than 0 and value adjaccent to k is greater than k
            while (position > 0 && A.get(position - 1) > k) {
                //swap the k and position elements so that now the higher element is after
                A.set(position, A.get(position - 1));
                counterShift++;
                counterComparison++;
                //position goes down one index
                position--;

            }
            // k is now set to the index position. Now the lower value is followed by higher value
            A.set(position, k);
            counterShift++;
        }
        //set counters to static variables
        insertionLoopCounter = counterLoop;
        insertionComparisonCounter = counterComparison;
        insertionShiftCounter = counterShift;
        //end time count and set time to variable
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        insertionTime = elapsed;
    }
//RECURSIVE DESCENDING INSERTION SORT FUNCTION

    public static void descendingInsertionSort(ArrayList<Integer> A) {
        //start timer
        long start, finish, elapsed;
        start = System.currentTimeMillis();

        //set int variables
        int k;
        int position;
        int counterLoop = 0;
        int counterComparison = 0;
        int counterShift = 0;

        //for all elements in list starting with second element
        for (int i = 1; i < A.size(); i++) {
            //set k to element at i index
            k = A.get(i);
            // position takes index i
            position = i;
            counterLoop++;
            // while position is lower than 0 and value adjaccent to k is greater than k
            while (position > 0 && A.get(position - 1) < k) {
                //swap the k and position elements so that now the lesser element is after
                A.set(position, A.get(position - 1));
                counterShift++;
                counterComparison++;
                //position goes down one index
                position--;

            }
            // k is now set to the index position. Now the higher value is followed by lower value
            A.set(position, k);
            counterShift++;
        }

        //set counters to static variables
        insertionLoopCounter = counterLoop;
        insertionComparisonCounter = counterComparison;
        insertionShiftCounter = counterShift;
        //end time count and set time to variable
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        insertionTime = elapsed;
    }

    /** Creates new form SortingEfficiencyM15 */
    public SortingEfficiencyM15() {
        initComponents();
        getContentPane().setBackground(Color.pink);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        outputResults = new javax.swing.JTextArea();
        sortingLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputSorting = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputOriginal = new javax.swing.JTextArea();
        descendingButton = new javax.swing.JRadioButton();
        originalLabel = new javax.swing.JLabel();
        prompLabel = new javax.swing.JLabel();
        sortResult = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        ascendingButton = new javax.swing.JRadioButton();
        radioButton5000 = new javax.swing.JRadioButton();
        radioButton1000 = new javax.swing.JRadioButton();
        radioButton100 = new javax.swing.JRadioButton();
        radioButton10 = new javax.swing.JRadioButton();
        sortLabel = new javax.swing.JLabel();
        sortButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputResults.setBackground(new java.awt.Color(255, 255, 204));
        outputResults.setColumns(20);
        outputResults.setFont(new java.awt.Font("Constantia", 1, 13)); // NOI18N
        outputResults.setForeground(new java.awt.Color(153, 51, 0));
        outputResults.setRows(5);
        jScrollPane3.setViewportView(outputResults);

        sortingLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 12));
        sortingLabel.setForeground(new java.awt.Color(0, 102, 102));
        sortingLabel.setText("Sorting Numbers");

        outputSorting.setBackground(new java.awt.Color(153, 255, 255));
        outputSorting.setColumns(20);
        outputSorting.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        outputSorting.setForeground(new java.awt.Color(102, 0, 102));
        outputSorting.setRows(5);
        jScrollPane2.setViewportView(outputSorting);

        outputOriginal.setBackground(new java.awt.Color(204, 255, 204));
        outputOriginal.setColumns(20);
        outputOriginal.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        outputOriginal.setForeground(new java.awt.Color(0, 0, 255));
        outputOriginal.setRows(5);
        jScrollPane1.setViewportView(outputOriginal);

        descendingButton.setBackground(java.awt.Color.pink);
        descendingButton.setFont(new java.awt.Font("Arial Black", 0, 11));
        descendingButton.setText("Descending");

        originalLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        originalLabel.setForeground(new java.awt.Color(0, 102, 102));
        originalLabel.setText("Original Numbers");

        prompLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        prompLabel.setForeground(new java.awt.Color(0, 51, 204));
        prompLabel.setText("Enter the amount of Numbers in the list:");

        sortResult.setFont(new java.awt.Font("Palatino Linotype", 1, 12));
        sortResult.setForeground(new java.awt.Color(0, 102, 102));
        sortResult.setText("Sort Results");

        titleLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 24));
        titleLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleLabel.setText("Sorting Efficiencies");

        ascendingButton.setBackground(java.awt.Color.pink);
        ascendingButton.setFont(new java.awt.Font("Arial Black", 0, 11));
        ascendingButton.setText("Ascending");

        radioButton5000.setBackground(java.awt.Color.pink);
        radioButton5000.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        radioButton5000.setText("5000");

        radioButton1000.setBackground(java.awt.Color.pink);
        radioButton1000.setFont(new java.awt.Font("Arial Black", 0, 11));
        radioButton1000.setText("1000");

        radioButton100.setBackground(java.awt.Color.pink);
        radioButton100.setFont(new java.awt.Font("Arial Black", 0, 11));
        radioButton100.setText("100");

        radioButton10.setBackground(java.awt.Color.pink);
        radioButton10.setFont(new java.awt.Font("Arial Black", 0, 11));
        radioButton10.setText("10");

        sortLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 12));
        sortLabel.setText("Sort Order");

        sortButton.setBackground(new java.awt.Color(204, 255, 204));
        sortButton.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        sortButton.setText("Sort Numbers");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 204, 0));
        exitButton.setFont(new java.awt.Font("Georgia", 0, 11));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/empty_hourglass-104.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(sortLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(descendingButton)
                                                    .addComponent(ascendingButton)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(47, 47, 47))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(originalLabel)
                                                        .addGap(56, 56, 56)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sortingLabel)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(exitButton)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(sortResult)
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel1))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(prompLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioButton10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioButton100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioButton1000)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioButton5000))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(sortButton)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(titleLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prompLabel)
                            .addComponent(radioButton10)
                            .addComponent(radioButton100)
                            .addComponent(radioButton1000)
                            .addComponent(radioButton5000))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sortLabel)
                            .addComponent(ascendingButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descendingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(originalLabel)
                            .addComponent(sortingLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sortResult)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
//Clears the output Areas and the arrayList
        outputOriginal.setText("");
        outputSorting.setText("");
        outputResults.setText("");
        numbers.clear();


//If 10 is selected from radio button
        if (radioButton10.isSelected() == true) {
            if (ascendingButton.isSelected() == false && descendingButton.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Please select ascending or descending order");
            }

            //If ASCENDING is selected, then use ASCENDING functions
            if (ascendingButton.isSelected() == true) {
                for (int i = 0; i < 10; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }
                ascendingSortSelection(numbers);
                ascendingBubbleSort(numbers);
                ascendingInsertionSort(numbers);
                for (int i = 0; i < 10; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

            } //If DESCENDNING is seleceted then use DESCENDING functions
            else if (descendingButton.isSelected() == true) {

                //generate 10 random numbers within given range
                for (int i = 0; i < 10; i++) {
                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    //add this to "numbers"
                    numbers.add(numGenerator);
                }
                //call functions
                descendingSortSelection(numbers);
                descendingBubbleSort(numbers);
                descendingInsertionSort(numbers);

                for (int i = 0; i < 10; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                //output the results with the timing for each loop and using all the counters.
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

            }

            //otherwise if they selected 100
        } else if (radioButton100.isSelected() == true) {
            //making sure they have selected either descending or ascending
            if (ascendingButton.isSelected() == false && descendingButton.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Please select ascending or descending order");
            }
            //if they select ascending then similar process as before, generate 100 random numbers
            if (ascendingButton.isSelected() == true) {
                for (int i = 0; i < 100; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }
                //call functions
                ascendingSortSelection(numbers);
                ascendingBubbleSort(numbers);
                ascendingInsertionSort(numbers);

                //display numbers being sorted
                for (int i = 0; i < 100; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                //output results
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");


                //otherwise if desecending is selecting then call the descending fnctions
            } else if (descendingButton.isSelected() == true) {
                for (int i = 0; i < 100; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }

                //desc functions
                descendingSortSelection(numbers);
                descendingBubbleSort(numbers);
                descendingInsertionSort(numbers);

                //display numbers being sorted
                for (int i = 0; i < 100; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                //output results
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

            }
            //otherwise if they selected 1000
        } else if (radioButton1000.isSelected() == true) {
            //make sure button is selected for order
            if (ascendingButton.isSelected() == false && descendingButton.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Please select ascending or descending order");
            }

            // if ascending
            if (ascendingButton.isSelected() == true) {
                //generate 1000 numbers within given range
                for (int i = 0; i < 1000; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }
                //call ascending functions
                ascendingSortSelection(numbers);
                ascendingBubbleSort(numbers);
                ascendingInsertionSort(numbers);
                for (int i = 0; i < 1000; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                //output results
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

                //otherwise if descending is selected
            } else if (descendingButton.isSelected() == true) {
                //generate 1000 rand num within given range
                for (int i = 0; i < 1000; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }
                //descending functions
                descendingSortSelection(numbers);
                descendingBubbleSort(numbers);
                descendingInsertionSort(numbers);

                for (int i = 0; i < 1000; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                //output results
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

            }

            //otherwsie if they have slected 5000 radio button
        } else if (radioButton5000.isSelected() == true) {
            //make sure order is selected
            if (ascendingButton.isSelected() == false && descendingButton.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Please select ascending or descending order");
            }
            //if they've selected ascending
            if (ascendingButton.isSelected() == true) {
                //generate 5000 rand num within given range
                for (int i = 0; i < 5000; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    //display these numbers
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }
                ascendingSortSelection(numbers);
                ascendingBubbleSort(numbers);
                ascendingInsertionSort(numbers);

                //display numbers being sorted
                for (int i = 0; i < 5000; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

                //otherwise if they want descending order
            } else if (descendingButton.isSelected() == true) {
                //generate the 5000 random number within range
                for (int i = 0; i < 5000; i++) {

                    int numGenerator = randomNum(-10000, 10000);
                    outputOriginal.append((Integer.toString(numGenerator)) + "\n");
                    numbers.add(numGenerator);
                }

                //use desc functions
                descendingSortSelection(numbers);
                descendingBubbleSort(numbers);
                descendingInsertionSort(numbers);
                //display numbers being sorted
                for (int i = 0; i < 5000; i++) {
                    outputSorting.append((Integer.toString(numbers.get(i))) + "\n");
                }

                //Display results
                outputResults.setText("\n" + "Selection Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(selectionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(selectionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(selectionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(selectionTime)
                        + "\n" + "Bubble Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(bubbleLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(bubbleComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(bubbleShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(bubbleTime)
                        + "\n" + "Insertion Sort" + "\n" + "Number of times the loop was executed: " + Integer.toString(insertionLoopCounter) + "\n" + "Number of times a comparison was made: " + Integer.toString(insertionComparisonCounter) + "\n" + "Number of times a value was shifted: " + Integer.toString(insertionShiftCounter) + "\n" + "Number of milliseconds it took to complete sort: " + Long.toString(insertionTime) + "\n");

            }

        } else {
            //prompt user to not leave all buttons unselected
            JOptionPane.showMessageDialog(null, "Please select the amount of numbers you want in the list");
        }
        //clear button selection
        radioButton10.setSelected(false);
        radioButton100.setSelected(false);
        radioButton1000.setSelected(false);
        radioButton5000.setSelected(false);
        descendingButton.setSelected(false);
        ascendingButton.setSelected(false);
    }//GEN-LAST:event_sortButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SortingEfficiencyM15().setVisible(true);
                JOptionPane.showMessageDialog(null, "Please Select How Many Numbers and whether you want them in Descending or Ascending Order!");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascendingButton;
    private javax.swing.JRadioButton descendingButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel originalLabel;
    private javax.swing.JTextArea outputOriginal;
    private javax.swing.JTextArea outputResults;
    private javax.swing.JTextArea outputSorting;
    private javax.swing.JLabel prompLabel;
    private javax.swing.JRadioButton radioButton10;
    private javax.swing.JRadioButton radioButton100;
    private javax.swing.JRadioButton radioButton1000;
    private javax.swing.JRadioButton radioButton5000;
    private javax.swing.JButton sortButton;
    private javax.swing.JLabel sortLabel;
    private javax.swing.JLabel sortResult;
    private javax.swing.JLabel sortingLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
