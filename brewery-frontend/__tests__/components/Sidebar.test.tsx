import { render, screen } from '@testing-library/react';
import Sidebar from '@/components/Sidebar';

describe('Sidebar', () => {
  it('Renders the sidebar', () => {
    render(<Sidebar />);
  });
});
