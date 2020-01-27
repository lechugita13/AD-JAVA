#ifndef DGRAFICOBOLAS_H
#define DGRAFICOBOLAS_H

#include <QDialog>
#include <QMainWindow>
#include <QChartView>
#include <QLineSeries>
#include <QChart>
#include <QValueAxis>
#include <QLabel>
#include <QBarSeries>
#include <QBarCategoryAxis>
#include <QBarSet>
#include <QHBoxLayout>
#include <QVector>
#include "ui_DGraficoBolas.h"
#include "bola.h"

QT_CHARTS_USE_NAMESPACE

class DGraficoBolas : public QDialog,  public Ui::DGraficoBolas {
Q_OBJECT
public:
        DGraficoBolas(QVector<Bola*>*bolas,QWidget *parent=0);
        QChart *chart;
        QChartView *chartView;
        QLineSeries *serie;     
        QBarSeries *series;
        QHBoxLayout * layout;
           QStringList categories;
       
};

#endif  //DINFORMACION_H
 