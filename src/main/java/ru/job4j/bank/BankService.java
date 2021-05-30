package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу нашего банка,
 * может добавлять новых пользователей,
 * добавлять новые счета,
 * осуществлять поиск пользователя по паспорту или счету,
 * переводить деньги между счетами.
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о клиентах и их счетах осуществляется
     * в колекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового клиента, если он является уникальным.
     * @param user наш клиент.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет нашему клиенту.
     * Поиск клиента осуществляется по номеру паспорта.
     * @param passport номер паспорта клиента.
     * @param account счет клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод поиска клиента по номеру паспорта.
     * @param passport номер паспорта клиента.
     * @return возвращает пользователя или null если такого пользователя нет.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск счета клиента.
     * @param passport паспорт клиента.
     * @param requisite счет клиента.
     * @return возвращает счет клиента или null если такого счета нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> account = users.get(user);
            return account.stream()
                    .filter(item -> item.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денежных средств, между счетами двух клиентов.
     * @param srcPassport паспорт клинета который переводит средства.
     * @param srcRequisite счет клиента с которого переводят средства.
     * @param destPassport паспорт клиента которому переводят средства.
     * @param destRequisite счет клиента на который переводят средства.
     * @param amount сумма перевода.
     * @return возвращает булевое значение результата перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}