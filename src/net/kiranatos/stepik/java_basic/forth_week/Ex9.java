package net.kiranatos.stepik.java_basic.forth_week;

import java.util.logging.*;

public class Ex9 {
    
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    
    /* Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо. */    
    public static interface Sendable {
        String getFrom();
        String getTo();
    }
    
    /* Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса. */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;
        
        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public String getFrom() {
            return from;
        }
        
        @Override
        public String getTo() {
            return to;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AbstractSendable that = (AbstractSendable) o;
            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;
            return true;
        }
    }
       
    /* Письмо, у которого есть текст, который можно получить с помощью метода `getMessage` */
    public static class MailMessage extends AbstractSendable {
        private final String message;
        
        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;            
            MailMessage that = (MailMessage) o;
            if (message != null ? !message.equals(that.message) : that.message != null) return false;
            return true;
        }
    }

    /* Посылка, содержимое которой можно получить с помощью метода `getContent` */    
    public static class MailPackage extends AbstractSendable {
        private final Package content;
        
        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }
        
        public Package getContent() {
            return content;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailPackage that = (MailPackage) o;
            if (!content.equals(that.content)) return false;
            return true;
        }
    }
    
    /* Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность. */
    public static class Package {
        private final String content;
        private final int price;
        
        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }
        
        public String getContent() {
            return content;
        }
        
        public int getPrice() {
            return price;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Package aPackage = (Package) o;
            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;
            return true;
        }
    }
    
    /* Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект. */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }
    
    /* Класс, в котором скрыта логика настоящей почты */
    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
    
    
    
    public static class UntrustworthyMailWorker implements MailService {
        private MailService[] mailService = null;
        private RealMailService realMailService = null;
        
        public UntrustworthyMailWorker(MailService[] mail){
            this.mailService = new MailService[mail.length];
            
            for (int i = 0; i< mailService.length; i++){
                this.mailService[i] = mail[i];
            }
            this.realMailService = new RealMailService();
        }
        
        public RealMailService getRealMailService(){
            return realMailService;
        }
        
        @Override        
        public Sendable processMail(Sendable mail) {     
            for(int i = 0; i<this.mailService.length; i++){
                mail = this.mailService[i].processMail(mail);
            }
            return getRealMailService().processMail(mail);
        }
    }

    public static class Spy implements MailService {
        
        private Logger log;

        public Spy(Logger log) {
            this.log = log;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            
            if (mail instanceof MailMessage) {
                MailMessage mm = (MailMessage)mail;
                if( (mm.getFrom().equals(AUSTIN_POWERS)) || ((mm.getTo().equals(AUSTIN_POWERS))) ) {
                    String[] s = new String[] { mm.getFrom(), mm.getTo(), mm.getMessage() };
                    log.log( Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", s);
                } else {
                    String[] s = new String[] { mm.getFrom(), mm.getTo() };
                    log.log( Level.INFO, "Usual correspondence: from {0} to {1}", s);
                }
                
            }
            return mail;            
        }
    }
    
    public static class Thief implements MailService {
        
        private int minValue;
        private int all = 0;

        public Thief(int minValue) {
            this.minValue = minValue;
        }
        
        public int getStolenValue(){ return all; }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mp = (MailPackage)mail;                
                int value = mp.getContent().getPrice();
                if (value>=minValue) {
                    String message = "stones instead of " + mp.getContent().getContent();
                    all += value;  
                    return new MailPackage( mp.getFrom(), mp.getTo(), new Package(message, 0));                
                }
            }
            return mail;            
        }
    }
    
    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mp = (MailPackage)mail;
                String con = mp.getContent().getContent();
                if ( (con.equals(WEAPONS)) || (con.equals(BANNED_SUBSTANCE)) ) { throw new IllegalPackageException(); }
                else if (con.contains("stones")) { throw new StolenPackageException(); }
                else return mail;                
            }
            return mail; 
        }
    }
    
    public static class StolenPackageException extends RuntimeException { }
    public static class IllegalPackageException extends RuntimeException { }

}

