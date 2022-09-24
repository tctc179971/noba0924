package com.example.noba;

class account {
    private int userID;
    private String account, name;

    public account(int userID, String account, String name) {
        this.userID = userID;
        this.account = account;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

class User extends account {
    public room room = null;

    public User(int userID, String account, String name) {
        super(userID, account, name);
    }

    public void join(room room) {
        room.add(this);
    }

    public room createRoom() {
        this.room = new room(this);
        return room;
    }

}

class administrator extends account {
    public administrator(int userID, String account, String name) {
        super(userID, account, name);
    }
}

class room {
    private int hostID;
    private User[] member = new User[4];

    public room(User user) {

        if (user != null) {
            hostID = user.getUserID();
            this.init();
            member[0] = user;
        }
    }

    public boolean add(User user) {
        if (user != null) {
            member[checkMember()] = user;
            return true;
        } else {
            return false;
        }
    }

    public void init() {
        for (int i = 0; i < member.length; i++) {
            member[i] = null;
        }
    }

    public int checkMember() {
        for (int i = 0; i < member.length; i++) {
            if (member[i] == null) {
                return i; //回傳空的索引
            }
        }
        return member.length;
    }
}
