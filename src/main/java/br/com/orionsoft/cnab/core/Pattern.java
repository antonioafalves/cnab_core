package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Field;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Pattern {
    ALPHANUMERIC {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (field.size() > 0) {
                    result = String.format("%-" + field.size() + "s", value);
                } else {
                    result = value.toString();
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    NUMERIC {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (!(value instanceof Number)) {
                    value = Long.parseLong((String) value);
                }
                result = String.format("%" + (field.fixed() ? "0" : "") + field.size() + "d", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DECIMAL {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%" + (field.fixed() ? "0" : "") + (field.size() + 1) + ".2f", value).replaceAll(",", "");
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    TIME {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$tH%1$tM%1$tS", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_DDMMAA {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$td%1$tm%1$ty", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_AAMMDD {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$ty%1$tm%1$td", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_DDMMAAAA {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$td%1$tm%1$tY", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_MMAAAA {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$tm%1$tY", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_DD_MM_AAAA {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$td/%1$tm/%1$tY", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    },
    DATE_AAAAMMDD {
        @Override
        public String format(Object value, Field field) {
            String result = "";
            try {
                if (value != null)
                    result = String.format("%1$tY%1$tm%1$td", value);
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
            }
            return result;
        }
    };

    public String format(Object value, Field field) {
        return null;
    }
}
