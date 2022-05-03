import { render, screen } from '@testing-library/react';
import FermentableForm from '@/components/FermentableForm';

describe('Sidebar', () => {
  it('Renders the Fermentable Form', () => {
    render(<FermentableForm />);

    screen.findByRole('textbox', { name: 'Fermentable Name' });
    screen.findByRole('textbox', { name: 'Supplier' });
    screen.findByRole('textbox', { name: 'Origin' });
    screen.findByRole('listbox', { name: 'Cats' });
  });
});
