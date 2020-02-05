import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteDosDosComponent } from './componente-dos-dos.component';

describe('ComponenteDosDosComponent', () => {
  let component: ComponenteDosDosComponent;
  let fixture: ComponentFixture<ComponenteDosDosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteDosDosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteDosDosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
