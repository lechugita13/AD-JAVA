#ifndef WIDGETPRE_H
#define WIDGETPRE_H

#include "ui_WidgetPRE.h"
#include <QDialog>
#include "bola.h"

class WidgetPRE : public QDialog, public Ui::WidgetPRE {

	Q_OBJECT
	
public:

	WidgetPRE(Bola * b,QWidget * parent = 0);
	Bola * bola;
	
public slots:


	void slotElegirColor(void);
    void slotElegirImagen(void);
    void slotCheckBoxText(void);
};

#endif
