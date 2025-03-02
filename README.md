# DA53 - Lexical Analyzer

## 📚 Project Overview
This project is the **first practical work** from the **DA53: Compilers and Language Theory** course, focusing on building a **lexical analyzer from scratch**. The goal is to understand how lexical analysis works, including the implementation of finite automata, symbol tables, and token generation.
The subject is the *DA53_LW1.pdf* file and the JavaDoc is generated in the **doc** folder.

Exeample of use : 

![alt text](img/image.png)

---

## 🚀 Objectives
- Define the language syntax and semantics (Tiny Basic dialect).
- Implement a **symbol table** to track variables and metadata.
- Develop a **lexer (lexical analyzer)** to identify tokens.
- Create a **finite automaton (FA)** to recognize language patterns.
- Integrate everything into a working **main program**.

---

---

## 🛠️ Technologies Used
- **Java** (preferred)
- **JavaDoc** for documentation
- Finite Automata for token recognition

---

## 🔍 Language Description (Tiny Basic Dialect)
### ✅ Supported Statements
- `PRINT expression`
- `IF condition THEN statement`
- `GOTO expression`
- `INPUT variable [, variable ...]`
- `LET variable = expression`
- `GOSUB expression` / `RETURN`
- `END`
- `REM comment`

### 🔢 Expressions
- Arithmetic operators: `+`, `-`, `*`, `/`
- Support for both **binary** and **unary** operators
- Strings enclosed in `"quotes"`

### 🌍 Variable Scope
- No declaration required
- Global scope for all variables
- Dynamic typing (numeric or string)


The lexer should produce tokens like:
```
<NUM,5> <LET> <ID,S> <=> <NUM,0>
<NUM,10> <INPUT> <ID,NUM>
...
```
