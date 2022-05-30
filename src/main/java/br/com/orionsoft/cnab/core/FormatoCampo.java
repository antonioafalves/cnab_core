package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Campo;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum FormatoCampo {
		ALFANUMERICO {
                @Override
                    public String formatar(Object value, Campo campo) {
                        String result = "";
                        try {
                            if (campo.tamanho() > 0) {
                                result = String.format("%-" + campo.tamanho() + "s", value);
                            } else {
                                result = value.toString();
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
                        }
                        return result;
                    }
                },
		NUMERICO {
                    @Override
                    public String formatar(Object value, Campo campo) {
                        String result = "";
                        try {
                            if (!(value instanceof Number)) {
                                value = Long.parseLong((String)value);
                            }
                            result = String.format("%" + (campo.fixo() ? "0" : "") + campo.tamanho() + "d", value);
                        } catch (Exception ex) {
                            Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
                        }
                        return result;
                    }
                },
		DECIMAL {
                    @Override
                    public String formatar(Object value, Campo campo) {
                        String result = "";
                        try {
                            if (value != null)
                                result = String.format("%" + (campo.fixo() ? "0" : "") + (campo.tamanho() + 1) + ".2f", value).replaceAll(",", "");
                        } catch (Exception ex) {
                            Logger.getLogger(this.getClass().getName()).log(Level.ALL, null, ex);
                        }
                        return result;
                    }
                },
		HORA,
		DATA_DDMMAA {
                    @Override
                    public String formatar(Object value, Campo campo) {
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
		DATA_AAMMDD {
                    @Override
                    public String formatar(Object value, Campo campo) {
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
		DATA_DDMMAAAA {
                    @Override
                    public String formatar(Object value, Campo campo) {
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
		DATA_MMAAAA {
                    @Override
                    public String formatar(Object value, Campo campo) {
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
		DATA_DD_MM_AAAA {
                    @Override
                    public String formatar(Object value, Campo campo) {
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
		DATA_AAAAMMDD {
                    @Override
                    public String formatar(Object value, Campo campo) {
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

                public String formatar(Object value, Campo campo) {
                    return null;
                }
}
