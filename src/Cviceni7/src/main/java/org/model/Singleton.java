package org.model;


    public class Singleton {
        private static Singleton instance;
        public String value;

        private Singleton(String value) {
            // soukromý konstruktor, aby se zabránilo vnější instanciaci
            this.value=value;
        }

        public static Singleton getInstance(String s) {
            if (instance == null) {
                instance = new Singleton(s);
            }
            return instance;
        }
    }


