public class MegaProblem1 {

    static class Account {
        private int balance;

        public Account(int initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }
    }

    static class BankTransfer implements Runnable {
        private final Account fromAccount;
        private final Account toAccount;
        private final int amount;

        public BankTransfer(Account fromAccount, Account toAccount, int amount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
        }

        @Override
        public void run() {
            fromAccount.withdraw(amount);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            toAccount.deposit(amount);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Account accountA = new Account(1000);
        Account accountB = new Account(1000);

        Thread t1 = new Thread(new BankTransfer(accountA, accountB, 100));
        Thread t2 = new Thread(new BankTransfer(accountB, accountA, 200));
        Thread t3 = new Thread(new BankTransfer(accountA, accountB, 150));
        Thread t4 = new Thread(new BankTransfer(accountB, accountA, 50));
        Thread t5 = new Thread(new BankTransfer(accountA, accountB, 300));
        Thread t6 = new Thread(new BankTransfer(accountB, accountA, 250));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();


        System.out.println("Final balance of account A: " + accountA.getBalance());
        System.out.println("Final balance of account B: " + accountB.getBalance());
    }
}