# ΠΧ4. Ανάγνωση Άρθρων

**Πρωτεύων Actor**: Χρήστης  
**Ενδιαφερόμενοι**  
**Χρήστης**: Να εισέλθει στην εφαρμογή και να διαβάσει ένα άρθρο.  
**Προϋποθέσεις**: Να υπάρχουν διαθέσιμα άρθρα προς ανάγνωση.    

## Βασική Ροή

1.	Ο χρήστης εισέρχεται στην εφαρμογή.
2.	Ο χρήστης πατάει το κουμπί το οποίο θα τον μεταφέρει στη κεντρική ροή άρθρων.
3.	Το σύστημα ανακτά τα άρθρα που έχουν εγκριθεί από τον διαχειριστή του συστήματος μέχρι εκείνη τη χρονική στιγμή.
4.	Η εφαρμογή εμφανίζει στην οθόνη τα διαθέσιμα (εγκεκριμένα) άρθρα κατά φθίνουσα χρονολογική σειρά.
5.	Ο χρήστης πατώντας σε κάποιο άρθρο μπορεί να δεί τα περιεχόμενα (κείμενο-φωτογραφίες) του άρθρου.

## Εναλλακτικές Ροές
3.	Η ροή είναι άδεια και δεν υπάρχουν εγκεκριμένα άρθρα.  
	3α. Η περίπτωση χρήσης τερματίζει και ο χρήστης επιστρέφεται αυτόματα στην αρχική οθόνη.  
