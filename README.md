# Apache Camel LSP Client for Apache NetBeans IDE

A bachelor thesis project implementing a Language Server Protocol (LSP) client for Apache Camel integration framework in Apache NetBeans IDE.

## 📋 Project Overview

This repository contains the implementation of a Language Server Protocol client that provides enhanced development support for Apache Camel projects in Apache NetBeans IDE. The project includes:

- **LSPClient**: A NetBeans module providing LSP integration for Apache Camel
- **Thesis Documentation**: Complete bachelor thesis documentation in LaTeX format
- **Supporting Materials**: Figures, diagrams, and additional documentation

## 🎯 Project Goals

The main objective of this bachelor thesis is to design and implement a language client for Apache NetBeans IDE that integrates with the existing Apache Camel Language Server developed by Red Hat. This integration provides:

- **Code Completion**: Intelligent code suggestions for Camel URI elements
- **Validation**: Real-time validation of Camel routes and configurations
- **Documentation**: Inline documentation and help for Camel components
- **Error Detection**: Syntax and semantic error highlighting

## 🏗️ Repository Structure

```
├── LSPClient/                    # NetBeans module implementation
│   ├── src/main/java/           # Java source code
│   ├── libs/                    # Dependencies (camel-lsp-server)
│   └── pom.xml                  # Maven configuration
├── text/                        # Thesis documentation
│   ├── projekt.tex             # Main thesis document
│   ├── projekt-01-kapitoly-chapters.tex  # Thesis chapters
│   ├── projekt-20-literatura-bibliography.bib  # Bibliography
│   ├── obrazky-figures/        # Figures and diagrams
│   └── Makefile                # LaTeX compilation
├── api/                         # API dependencies
└── *.pdf                       # Generated thesis documents
```

## 🚀 Getting Started

### Prerequisites

- **Java 8+**: Required for building the NetBeans module
- **Apache NetBeans IDE**: Target platform for the LSP client
- **Maven 3.6+**: For dependency management and building
- **LaTeX**: For compiling thesis documentation (optional)

### Building the NetBeans Module

1. Navigate to the LSPClient directory:
   ```bash
   cd LSPClient
   ```

2. Build the module using Maven:
   ```bash
   mvn clean install
   ```

3. The built module (`.nbm` file) will be available in the `target/` directory

### Installing the Module

1. Open Apache NetBeans IDE
2. Go to **Tools** → **Plugins**
3. Click **Downloaded** tab
4. Click **Add Plugins** and select the generated `.nbm` file
5. Follow the installation wizard

## 📚 Thesis Documentation

The thesis is written in Czech and covers:

- **Introduction**: Motivation and project goals
- **Related Technologies**: Language Server Protocol, Apache Camel, NetBeans platform
- **Design**: Architecture and implementation approach
- **Implementation**: Detailed technical implementation
- **Testing**: Validation and testing procedures
- **Conclusion**: Results and future work

### Compiling the Thesis

To compile the LaTeX thesis:

```bash
cd text
make pdf
```

The generated PDF will be available as `projekt.pdf`.

## 🔧 Technical Details

### Dependencies

- **Apache Camel LSP Server**: Version 1.9.1
- **Apache NetBeans Platform**: RELEASE170
- **Java**: Version 8+
- **Maven**: For build management

### Key Components

- **CamelLSPClient**: Main LSP client implementation
- **ProcessPreferences**: Configuration management
- **Data Objects**: Support for XML, YAML, and Java files
- **Options Panel**: User configuration interface

### Supported File Types

- **XML**: Camel route definitions
- **YAML**: Camel configuration files  
- **Java**: Camel route builders

## 🎨 Features

- **Intelligent Code Completion**: Context-aware suggestions for Camel URI components
- **Real-time Validation**: Immediate feedback on syntax and semantic errors
- **Documentation Integration**: Inline help and component documentation
- **Multi-format Support**: XML, YAML, and Java file support
- **Configurable Settings**: User-customizable preferences

## 📊 Project Status

This is a completed bachelor thesis project that demonstrates:

- ✅ Complete LSP client implementation
- ✅ NetBeans module integration
- ✅ Multi-format file support
- ✅ User configuration options
- ✅ Comprehensive documentation

## 👨‍💻 Author

**Filip Pospisil**
Institution: VUT FIT (Brno University of Technology, Faculty of Information Technology)

## 📄 License

This project is part of a bachelor thesis and follows the academic guidelines of VUT FIT.

## 🤝 Contributing

This is an academic project completed as part of a bachelor thesis. For questions or suggestions, please contact the author.

## 📖 References

- [Language Server Protocol](https://microsoft.github.io/language-server-protocol/)
- [Apache Camel](https://camel.apache.org/)
- [Apache NetBeans](https://netbeans.apache.org/)
- [Camel LSP Server](https://github.com/camel-tooling/camel-language-server)

---

*This repository contains both the implementation code and the complete bachelor thesis documentation in Czech language.*
