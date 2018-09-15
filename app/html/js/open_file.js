






function openmydoc(path) {
            var doc = new ActiveXObject("Word.Application");
            doc.visible = true;
            doc.Documents.Open(path);
        }